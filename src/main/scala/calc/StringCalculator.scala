package calc


class StringCalculator {
  val DelimRE = """//(.+)\n.*""".r
  
  def add(numbers: String): Int = {
    implicit def toIntOverload(s: String) = new {
      def safeToInt: Int = if (s.matches("""^\d+$""")) s.toInt else 0
    }
    
    def extractPrefix(s: String): String = {
        val DelimRE(prefix) = s
        prefix
    }

    val extraPrefix = DelimRE.findPrefixOf(numbers) match { 
      case s: Some[String] => extractPrefix(numbers)
      case _ => ""     
    }  
    // Fold-left operator
    (0 /: numbers.split("""[,\n\$extraPrefix]+"""))((t, n) => t + n.safeToInt)
  }
}
