package learning;
object LoopsAndControl {
  def main(args: Array[String]): Unit = {
    Console.println(fiftyFifty())
    tenTimesPrint(fiftyFifty)
  }
  
  // Loop from ranges, and passing functions
  def tenTimesPrint(fun: () => String): Unit = {
    for (i <- 1 to 10)    
      Console.println(fun())
  }
  
  // Assignment from conditionals
  def fiftyFifty(): String = {
    val time = System.currentTimeMillis
    
    val fiftyFifty = 
      if (time%2 == 0)
        "Even"
      else 
        "Odd"
    fiftyFifty
  }
}