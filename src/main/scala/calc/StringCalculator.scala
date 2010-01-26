package calc



class StringCalculator {
  def add(numbers: String): Int = {
      implicit def toIntOverload(s: String) = new {
        def safeToInt: Int = if (s.isEmpty) 0 else s.toInt
      }
  
      (0 /: numbers.split("""[,\n]+"""))((t,n) => t + n.safeToInt)
    }
}
