package learning

object Singleton {
  val name = "Tony"
  private val age = 39
}
class Singleton {
  def age(): Int = {
    Singleton.age
  }
}
