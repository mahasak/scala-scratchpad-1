package learning
class Outcome {}

class Wrong extends Outcome {
  def +(that: Outcome): Outcome = {
    if (that.isInstanceOf[Right]) 
      new Hmmm
    else 
      this
  }
  override def equals(other: Any): Boolean = isInstanceOf[Wrong]
}

class Right extends Outcome {
  def +(that: Outcome): Outcome = {
    if (that.isInstanceOf[Wrong]) 
      new Hmmm
    else 
      this
  }
  override def equals(other: Any): Boolean = isInstanceOf[Right]
}

class Hmmm extends Outcome {
  def +(that: Outcome): Outcome = that
  override def equals(other: Any): Boolean = isInstanceOf[Hmmm]
}

object OperatorOverloading {
  def main(args: Array[String]): Unit = {
    val wrong = new Wrong
    val right = new Right
    val hmmm = new Hmmm
    
    assert ((wrong + wrong) == wrong)
    assert ((wrong + right) == hmmm)
    assert ((wrong + hmmm) == wrong)
    assert ((right + wrong) == hmmm)
    assert ((right + right) == right)
    assert ((right + hmmm) == right)
    assert ((hmmm + wrong) == wrong)
    assert ((hmmm + right) == right)
    assert ((hmmm + hmmm) == hmmm)
  }
}
