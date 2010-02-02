package calc


class StringCalculator {
   val DelimMatchRE = """(?s)//.{1}\n.*""".r
   val DelimExtractRE = """(?s)//(.{1})\n.*""".r

  
   def add(numbers: String): Int = {
    implicit def toIntOverload(s: String) = new {
      def safeToInt: Int = if (s.matches("""^\d+$""")) s.toInt else 0
    }
    
    def extractPrefix(s: String): String = {
        val DelimExtractRE(prefix) = s
        prefix
    }

    val extraPrefix = DelimMatchRE findPrefixOf numbers match { 
        case Some(s) => extractPrefix(numbers)
        case None => ""
    }  
    
    // Fold-left operator
    (0 /: numbers.split("""[,\n"""+ extraPrefix +"""]+"""))((t, n) => t + n.safeToInt)
  }
}
