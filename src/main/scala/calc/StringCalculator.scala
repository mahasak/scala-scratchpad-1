package calc


class StringCalculator {
   private val DelimRE = """(?s)//(.)\n.*""".r
   private val MaxIntValue = 1000

   private def safeToInt(s: String): Int = if (s.matches("""^\-{0,1}\d+$""")) s.toInt else 0
   private def filterOutOfRange(i: Int): Int = if (i < MaxIntValue) i else 0
   
   def add(input: String): Int = {
    def getDelim(s: String): String = {
        val DelimRE(prefix) = s
        prefix
    }
    
    val extraPrefix = DelimRE findPrefixOf input match { 
        case Some(s) => getDelim(input)
        case None => ""
    }  
    
    val splitExpression = """[,\n"""+ extraPrefix +"""]+"""
    
    val numbers = input.split(splitExpression).map(i => filterOutOfRange(safeToInt(i)))
    val negativeNumbers = numbers.filter(_<0)
    if (negativeNumbers.size > 0) throw new IllegalArgumentException("negatives not allowed: ["+ negativeNumbers.mkString(",") + "]")
    (0 /: numbers)(_+_)
  }
}
