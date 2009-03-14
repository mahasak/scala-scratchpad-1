package learning;

class Miscelany(val number: Int, val text: String) {
  // Overloaded constructor
  def this(number: Int) = this(number, "default")
}

object ConstructingThings {
  def main(args: Array[String]): Unit = {
    val misc1 = new Miscelany(1, "One")
    assert (misc1.number == 1)
    assert (misc1.text == "One")
    val misc2 = new Miscelany(2)
    assert (misc2.number == 2)
    assert (misc2.text == "default")
  }
  
}