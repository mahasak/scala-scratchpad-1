package calc


class StringCalculator {
   val DelimRE = """(?s)//(.)\n.*""".r

  
   def add(numbers: String): Int = {
    def safeToInt(s: String): Int = if (s.matches("""^\d+$""")) s.toInt else 0
    
    def getDelim(s: String): String = {
        val DelimRE(prefix) = s
        prefix
    }

    val extraPrefix = DelimRE findPrefixOf numbers match { 
        case Some(s) => getDelim(numbers)
        case None => ""
    }  
    
    val splitExpression = """[,\n"""+ extraPrefix +"""]+"""
    
    // Fold-left operator
    (0 /: numbers.split(splitExpression))((t, n) => t + safeToInt(n))
  }
}
