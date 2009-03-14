package learning

abstract class Outcome {
  val EVIL: String = "Evil"
  val NEUTRAL: String = "Neutral"
  val VIRTUOUS: String = "Virtuous"
}

class Wrong extends Outcome {
  def +(that: Wrong): String = EVIL
  def +(that: Right): String = NEUTRAL
}

class Right extends Outcome {
  def +(that: Wrong): String = NEUTRAL
  def +(that: Right): String = VIRTUOUS
}

object OperatorOverloading {
  def main(args: Array[String]): Unit = {
    val wrong = new Wrong
    val right = new Right
    assert ((wrong + new Wrong).equals(wrong.EVIL))
    assert ((wrong + new Right).equals(right.NEUTRAL))
    assert ((right + new Wrong).equals(right.NEUTRAL))
    assert ((right + new Right).equals(right.VIRTUOUS))
  }
}
