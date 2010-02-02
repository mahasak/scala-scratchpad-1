package calc


class StringCalculator {
    val DelimMatchRE = """(?s)//.{1}\n.*""".r
    val DelimExtractRE = """(?s)//(.{1})\n.*""".r
  
  def add(input: String): Int = {
    implicit def toIntOverload(s: String) = new {
      def safeToInt: Int = if (s.matches("""^\d+$""")) s.toInt else 0
    }
    
    def extractPrefix(s: String): (String, String) = {
        val DelimExtractRE(prefix) = s
        (prefix, s)
    }

    val (extraPrefix, numbers) = DelimMatchRE findPrefixOf input match { 
        case Some(s) => extractPrefix(input)
        case None => ("", input)     
    }  
    
    // Fold-left operator
    (0 /: numbers.split("""[,\n"""+ extraPrefix +"""]+"""))((t, n) => t + n.safeToInt)
  }
}
