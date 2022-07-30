package lila.game

import akka.actor._
import com.softwaremill.macwire._
import com.softwaremill.tagging._
import io.methvin.play.autoconfig._
import play.api.Configuration
import play.api.libs.ws.StandaloneWSClient
import scala.concurrent.duration._

import lila.common.config._

final private class GameConfig(
    @ConfigName("collection.game") val gameColl: CollName,
    @ConfigName("collection.crosstable") val crosstableColl: CollName,
    @ConfigName("collection.matchup") val matchupColl: CollName,
    @ConfigName("captcher.name") val captcherName: String,
    @ConfigName("captcher.duration") val captcherDuration: FiniteDuration,
    val gifUrl: String
)

@Module
final class Env(
    appConfig: Configuration,
    ws: StandaloneWSClient,
    db: lila.db.Db,
    yoloDb: lila.db.AsyncDb @@ lila.db.YoloDb,
    baseUrl: BaseUrl,
    userRepo: lila.user.UserRepo,
    mongoCache: lila.memo.MongoCache.Api,
    lightUserApi: lila.user.LightUserApi,
    cacheApi: lila.memo.CacheApi,
    netDomain: NetDomain
)(implicit
    ec: scala.concurrent.ExecutionContext,
    system: ActorSystem,
    scheduler: Scheduler,
    mode: play.api.Mode
) {

  private val config = appConfig.get[GameConfig]("game")(AutoConfig.loader)

  lazy val gameRepo = new GameRepo(db(config.gameColl))

  lazy val idGenerator = wire[IdGenerator]

  lazy val gifExport = new GifExport(ws, lightUserApi, baseUrl, config.gifUrl)

  lazy val divider = wire[Divider]

  lazy val cached: Cached = wire[Cached]

  lazy val paginator = wire[PaginatorBuilder]

  lazy val uciMemo = wire[UciMemo]

  lazy val pgnDump = wire[PgnDump]

  lazy val crosstableApi = new CrosstableApi(
    coll = db(config.crosstableColl),
    matchupColl = yoloDb(config.matchupColl).failingSilently()
  )

  lazy val gamesByUsersStream = wire[GamesByUsersStream]

  lazy val favoriteOpponents = wire[FavoriteOpponents]

  lazy val rematches = wire[Rematches]

  lazy val jsonView = wire[JsonView]

  lazy val textExpand = wire[GameTextExpand]

  // eargerly load captcher actor
  private val captcher = system.actorOf(Props(new Captcher(gameRepo)), name = config.captcherName)
  scheduler.scheduleWithFixedDelay(config.captcherDuration, config.captcherDuration) { () =>
    captcher ! actorApi.NewCaptcha
  }
}
