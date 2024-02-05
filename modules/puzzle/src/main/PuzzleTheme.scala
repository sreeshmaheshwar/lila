package lila.puzzle

import lila.i18n.I18nKeys.{ puzzleTheme as i }
import lila.i18n.{ I18nKey, I18nKeys as trans }

import scala.util.control.Breaks.{break, breakable}

case class PuzzleTheme(key: PuzzleTheme.Key, name: I18nKey, description: I18nKey)

object PuzzleTheme:

  opaque type Key = String
  object Key extends OpaqueString[Key]

  case class WithCount(theme: PuzzleTheme, count: Int)

  val mix           = PuzzleTheme(Key("mix"), i.healthyMix, i.healthyMixDescription)
  val advancedPawn  = PuzzleTheme(Key("advancedPawn"), i.advancedPawn, i.advancedPawnDescription)
  val advantage     = PuzzleTheme(Key("advantage"), i.advantage, i.advantageDescription)
  val anastasiaMate = PuzzleTheme(Key("anastasiaMate"), i.anastasiaMate, i.anastasiaMateDescription)
  val arabianMate   = PuzzleTheme(Key("arabianMate"), i.arabianMate, i.arabianMateDescription)
  val attackingF2F7 = PuzzleTheme(Key("attackingF2F7"), i.attackingF2F7, i.attackingF2F7Description)
  val attraction    = PuzzleTheme(Key("attraction"), i.attraction, i.attractionDescription)
  val backRankMate  = PuzzleTheme(Key("backRankMate"), i.backRankMate, i.backRankMateDescription)
  val bishopEndgame = PuzzleTheme(Key("bishopEndgame"), i.bishopEndgame, i.bishopEndgameDescription)
  val bodenMate     = PuzzleTheme(Key("bodenMate"), i.bodenMate, i.bodenMateDescription)
  val capturingDefender =
    PuzzleTheme(Key("capturingDefender"), i.capturingDefender, i.capturingDefenderDescription)
  val castling      = PuzzleTheme(Key("castling"), i.castling, i.castlingDescription)
  val clearance     = PuzzleTheme(Key("clearance"), i.clearance, i.clearanceDescription)
  val crushing      = PuzzleTheme(Key("crushing"), i.crushing, i.crushingDescription)
  val defensiveMove = PuzzleTheme(Key("defensiveMove"), i.defensiveMove, i.defensiveMoveDescription)
  val deflection    = PuzzleTheme(Key("deflection"), i.deflection, i.deflectionDescription)
  val discoveredAttack =
    PuzzleTheme(Key("discoveredAttack"), i.discoveredAttack, i.discoveredAttackDescription)
  val doubleBishopMate =
    PuzzleTheme(Key("doubleBishopMate"), i.doubleBishopMate, i.doubleBishopMateDescription)
  val doubleCheck = PuzzleTheme(Key("doubleCheck"), i.doubleCheck, i.doubleCheckDescription)
  val dovetailMate =
    PuzzleTheme(Key("dovetailMate"), i.dovetailMate, i.dovetailMateDescription)
  val equality       = PuzzleTheme(Key("equality"), i.equality, i.equalityDescription)
  val endgame        = PuzzleTheme(Key("endgame"), i.endgame, i.endgameDescription)
  val enPassant      = PuzzleTheme(Key("enPassant"), trans.learn.enPassant, i.enPassantDescription)
  val exposedKing    = PuzzleTheme(Key("exposedKing"), i.exposedKing, i.exposedKingDescription)
  val fork           = PuzzleTheme(Key("fork"), i.fork, i.forkDescription)
  val hangingPiece   = PuzzleTheme(Key("hangingPiece"), i.hangingPiece, i.hangingPieceDescription)
  val hookMate       = PuzzleTheme(Key("hookMate"), i.hookMate, i.hookMateDescription)
  val interference   = PuzzleTheme(Key("interference"), i.interference, i.interferenceDescription)
  val intermezzo     = PuzzleTheme(Key("intermezzo"), i.intermezzo, i.intermezzoDescription)
  val kingsideAttack = PuzzleTheme(Key("kingsideAttack"), i.kingsideAttack, i.kingsideAttackDescription)
  val knightEndgame  = PuzzleTheme(Key("knightEndgame"), i.knightEndgame, i.knightEndgameDescription)
  val long           = PuzzleTheme(Key("long"), i.long, i.longDescription)
  val master         = PuzzleTheme(Key("master"), i.master, i.masterDescription)
  val masterVsMaster = PuzzleTheme(Key("masterVsMaster"), i.masterVsMaster, i.masterVsMasterDescription)
  val mate           = PuzzleTheme(Key("mate"), i.mate, i.mateDescription)
  val mateIn1        = PuzzleTheme(Key("mateIn1"), i.mateIn1, i.mateIn1Description)
  val mateIn2        = PuzzleTheme(Key("mateIn2"), i.mateIn2, i.mateIn2Description)
  val mateIn3        = PuzzleTheme(Key("mateIn3"), i.mateIn3, i.mateIn3Description)
  val mateIn4        = PuzzleTheme(Key("mateIn4"), i.mateIn4, i.mateIn4Description)
  val mateIn5        = PuzzleTheme(Key("mateIn5"), i.mateIn5, i.mateIn5Description)
  val smotheredMate  = PuzzleTheme(Key("smotheredMate"), i.smotheredMate, i.smotheredMateDescription)
  val middlegame     = PuzzleTheme(Key("middlegame"), i.middlegame, i.middlegameDescription)
  val oneMove        = PuzzleTheme(Key("oneMove"), i.oneMove, i.oneMoveDescription)
  val opening        = PuzzleTheme(Key("opening"), i.opening, i.openingDescription)
  val pawnEndgame    = PuzzleTheme(Key("pawnEndgame"), i.pawnEndgame, i.pawnEndgameDescription)
  val pin            = PuzzleTheme(Key("pin"), i.pin, i.pinDescription)
  val promotion      = PuzzleTheme(Key("promotion"), i.promotion, i.promotionDescription)
  val queenEndgame   = PuzzleTheme(Key("queenEndgame"), i.queenEndgame, i.queenEndgameDescription)
  val queenRookEndgame =
    PuzzleTheme(Key("queenRookEndgame"), i.queenRookEndgame, i.queenRookEndgameDescription)
  val queensideAttack = PuzzleTheme(Key("queensideAttack"), i.queensideAttack, i.queensideAttackDescription)
  val quietMove       = PuzzleTheme(Key("quietMove"), i.quietMove, i.quietMoveDescription)
  val rookEndgame     = PuzzleTheme(Key("rookEndgame"), i.rookEndgame, i.rookEndgameDescription)
  val sacrifice       = PuzzleTheme(Key("sacrifice"), i.sacrifice, i.sacrificeDescription)
  val short           = PuzzleTheme(Key("short"), i.short, i.shortDescription)
  val skewer          = PuzzleTheme(Key("skewer"), i.skewer, i.skewerDescription)
  val superGM         = PuzzleTheme(Key("superGM"), i.superGM, i.superGMDescription)
  val trappedPiece    = PuzzleTheme(Key("trappedPiece"), i.trappedPiece, i.trappedPieceDescription)
  val underPromotion  = PuzzleTheme(Key("underPromotion"), i.underPromotion, i.underPromotionDescription)
  val veryLong        = PuzzleTheme(Key("veryLong"), i.veryLong, i.veryLongDescription)
  val xRayAttack      = PuzzleTheme(Key("xRayAttack"), i.xRayAttack, i.xRayAttackDescription)
  val zugzwang        = PuzzleTheme(Key("zugzwang"), i.zugzwang, i.zugzwangDescription)
  val checkFirst      = PuzzleTheme(Key("checkFirst"), I18nKey("Check first"), I18nKey("Check first"))

  val irrelevantThemes = List(
    PuzzleTheme.oneMove,
    PuzzleTheme.short,
    PuzzleTheme.long,
    PuzzleTheme.veryLong,
    PuzzleTheme.mateIn1,
    PuzzleTheme.mateIn2,
    PuzzleTheme.mateIn3,
    PuzzleTheme.mateIn4,
    PuzzleTheme.mateIn5,
    PuzzleTheme.equality,
    PuzzleTheme.advantage,
    PuzzleTheme.crushing,
    PuzzleTheme.master,
    PuzzleTheme.masterVsMaster
  )
 
  val frequency = Map[PuzzleTheme, Int](
    advantage -> 1114122,
    anastasiaMate -> 3771,
    arabianMate -> 3596,
    attackingF2F7 -> 21543,
    attraction -> 127076,
    backRankMate -> 114855,
    bishopEndgame -> 43387,
    bodenMate -> 1443,
    capturingDefender -> 31572,
    castling -> 2005,
    clearance -> 50730,
    crushing -> 1633978,
    defensiveMove -> 225694,
    deflection -> 156856,
    advancedPawn -> 204065,
    discoveredAttack -> 209840,
    doubleBishopMate -> 1524,
    doubleCheck -> 17445,
    dovetailMate -> 1803,
    enPassant -> 5469,
    endgame -> 1711180,
    equality -> 42282,
    exposedKing -> 100602,
    fork -> 535211,
    hangingPiece -> 160635,
    hookMate -> 5161,
    interference -> 14820,
    intermezzo -> 53247,
    kingsideAttack -> 289540,
    knightEndgame -> 27976,
    long -> 920624,
    master -> 269971,
    masterVsMaster -> 25059,
    mate -> 915928,
    mateIn1 -> 358723,
    mateIn2 -> 432833,
    mateIn3 -> 105864,
    mateIn4 -> 15192,
    mateIn5 -> 3316,
    middlegame -> 1787974,
    oneMove -> 405488,
    opening -> 210061,
    pawnEndgame -> 105522,
    pin -> 237755,
    promotion -> 76801,
    queenEndgame -> 33873,
    queenRookEndgame -> 24052,
    queensideAttack -> 49786,
    quietMove -> 145702,
    rookEndgame -> 174835,
    sacrifice -> 263423,
    short -> 2085189,
    skewer -> 81626,
    smotheredMate -> 10284,
    superGM -> 2293,
    // superGM -> 3000000, // Uncomment to test retries.
    trappedPiece -> 54438,
    underPromotion -> 673,
    veryLong -> 295012,
    xRayAttack -> 12669,
    zugzwang -> 29968
    // `mix` and `checkFirst` are not present in our database.
  ).toMap.filterNot(x => irrelevantThemes.contains(x._1))

  val total = frequency.values.sum

  val random = new scala.util.Random

  def proportionallyRandomTheme: PuzzleTheme = {
    val x = random.nextInt(total)
    var offset = 0
    var result = mix
  
    breakable {
      for ((theme, f) <- frequency) {
        offset = offset + f
        if (x < offset) {
          result = theme
          break()
        }
      }
    }
    
    assert(result != mix)
    result
  }

  val categorized = List[(I18nKey, List[PuzzleTheme])](
    trans.puzzle.recommended -> List(
      mix
    ),
    trans.puzzle.phases -> List(
      opening,
      middlegame,
      endgame,
      rookEndgame,
      bishopEndgame,
      pawnEndgame,
      knightEndgame,
      queenEndgame,
      queenRookEndgame
    ),
    trans.puzzle.motifs -> List(
      advancedPawn,
      attackingF2F7,
      capturingDefender,
      discoveredAttack,
      doubleCheck,
      exposedKing,
      fork,
      hangingPiece,
      kingsideAttack,
      pin,
      queensideAttack,
      sacrifice,
      skewer,
      trappedPiece
    ),
    trans.puzzle.advanced -> List(
      attraction,
      clearance,
      defensiveMove,
      deflection,
      interference,
      intermezzo,
      quietMove,
      xRayAttack,
      zugzwang
    ),
    trans.puzzle.mates -> List(
      mate,
      mateIn1,
      mateIn2,
      mateIn3,
      mateIn4,
      mateIn5,
      anastasiaMate,
      arabianMate,
      backRankMate,
      bodenMate,
      doubleBishopMate,
      dovetailMate,
      hookMate,
      smotheredMate
    ),
    trans.puzzle.specialMoves -> List(
      castling,
      enPassant,
      promotion,
      underPromotion
    ),
    trans.puzzle.goals -> List(
      equality,
      advantage,
      crushing,
      mate
    ),
    trans.puzzle.lengths -> List(
      oneMove,
      short,
      long,
      veryLong
    ),
    trans.puzzle.origin -> List(
      master,
      masterVsMaster,
      superGM
    )
  )

  lazy val visible: List[PuzzleTheme] = categorized.flatMap(_._2)

  lazy val allTranslationKeys = visible.flatMap { t =>
    List(t.name, t.description)
  }

  private lazy val byKey: Map[Key, PuzzleTheme] = visible.mapBy(_.key)

  private lazy val byLowerKey: Map[String, PuzzleTheme] = visible.mapBy(_.key.value.toLowerCase)

  // themes that can't be voted by players
  val staticThemes: Set[Key] = Set(
    advantage,
    castling,
    crushing,
    enPassant,
    endgame,
    equality,
    long,
    master,
    masterVsMaster,
    superGM,
    mate,
    mateIn1,
    mateIn2,
    mateIn3,
    mateIn4,
    mateIn5,
    middlegame,
    oneMove,
    opening,
    short,
    smotheredMate,
    veryLong,
    checkFirst
  ).map(_.key)

  val allMates: Set[Key] = visible.filter(_.key.value.endsWith("Mate")).map(_.key).toSet

  // themes that can't be viewed by players
  val hiddenThemes: Set[Key] = Set(checkFirst.key)

  val studyChapterIds: Map[PuzzleTheme.Key, String] = List(
    advancedPawn      -> "sw8VyTe1",
    attackingF2F7     -> "r1ZAcrjZ",
    attraction        -> "3arGcr8n",
    backRankMate      -> "VVzwe5vV",
    capturingDefender -> "2s7CaC2h",
    castling          -> "edXPYM70",
    discoveredAttack  -> "DYcrqEPt",
    doubleCheck       -> "EXAQJVNm",
    enPassant         -> "G7ILIqhG",
    exposedKing       -> "K882yZgm",
    fork              -> "AUQW7PKS",
    hangingPiece      -> "y65GVqXf",
    kingsideAttack    -> "f62Rz8Qb",
    pin               -> "WCTmpBFb",
    promotion         -> "BNuCO8JO",
    skewer            -> "iF38PGid",
    clearance         -> "ZZsl7iCi",
    trappedPiece      -> "ZJQkwFP6",
    sacrifice         -> "ezFdOVtv",
    interference      -> "nAojbDwV"
  ).view.map { (theme, id) =>
    theme.key -> id
  }.toMap

  def apply(key: Key): PuzzleTheme = byKey.getOrElse(key, mix)

  def find(key: String) = byLowerKey get key.toLowerCase

  def findOrMix(key: Key) = find(key) | mix

  def findDynamic(key: String) = find(key).filterNot(t => staticThemes(t.key))
