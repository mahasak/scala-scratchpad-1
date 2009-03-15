package learning;
object LoopsAndControl {
  def main(args: Array[String]): Unit = {
    Console.println(fiftyFifty())
    tenTimesPrint(fiftyFifty)
    
    // Filters in loops
    for (val i <- 1 to 10; (i%3 == 0))
      Console.println("In threes: " + i)
    
    // Can be other things too, so long as each 'step'
    // returns a boolean
    for (val i <- 1 to 30; logIt(i); i%10 == 0)
      Console.println(i + " fits!")
  }
  
  def logIt(i: Int): Boolean = {
    Console.println("Trying " + i)
    true
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
      time%2 match {
        case 0 => "Even"
        case _ => "Odd"
      }

    fiftyFifty
  }
}