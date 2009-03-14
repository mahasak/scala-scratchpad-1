package learning
class Outcome {}

class Wrong extends Outcome {
  def +(that: Outcome): Outcome = {
    if (that.isInstanceOf[Right]) 
      new Hmmm
    else 
      this
  }
}

class Right extends Outcome {
  def +(that: Outcome): Outcome = {
    if (that.isInstanceOf[Wrong]) 
      new Hmmm
    else 
      this
  }
}

class Hmmm extends Outcome {
  def +(that: Outcome): Outcome = that
}

object OperatorOverloading {
  def main(args: Array[String]): Unit = {
    val wrong = new Wrong
    val right = new Right
    val hmmm = new Hmmm
    
    assert ((wrong + wrong).isInstanceOf[Wrong] )
    assert ((wrong + right).isInstanceOf[Hmmm])
    assert ((wrong + hmmm).isInstanceOf[Wrong])
    assert ((right + wrong).isInstanceOf[Hmmm])
    assert ((right + right).isInstanceOf[Right])
    assert ((right + hmmm).isInstanceOf[Right])
    assert ((hmmm + wrong).isInstanceOf[Wrong])
    assert ((hmmm + right).isInstanceOf[Right])
    assert ((hmmm + hmmm).isInstanceOf[Hmmm])
  }
}
