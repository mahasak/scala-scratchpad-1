package learning
abstract class Outcome() {
  // eq() checks instance equality
  override def equals(other: Any): Boolean = eq(this)
}

/*
 * case-classes/objects allow the class to be used in a match block
 */
case object Wrong extends Outcome {
  def +(that: Outcome): Outcome = {
    that match {
      case Right => Hmmm
      case _ => this
    }
  }
}

case object Right extends Outcome {
  def +(that: Outcome): Outcome = {
    that match {
      case Wrong => Hmmm
      case _ => this
    }
  }
}

case object Hmmm extends Outcome {
  def +(that: Outcome): Outcome = that
}

object OperatorOverloadingAndCaseClasses {
  def main(args: Array[String]): Unit = {
    val wrong = Wrong
    val right = Right
    val hmmm = Hmmm

    assert ((wrong + wrong) == Wrong)
    assert ((wrong + right) == Hmmm)
    assert ((wrong + hmmm) == Wrong)
    assert ((right + wrong) == Hmmm)
    assert ((right + right) == Right)
    assert ((right + hmmm) == Right)
    assert ((hmmm + wrong) == Wrong)
    assert ((hmmm + right) == Right)
    assert ((hmmm + hmmm) == Hmmm)
    Console.println("Done")
  }
}
