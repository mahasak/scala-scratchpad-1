package learning

class Rational(val num: Int, val denom: Int) {
    require (denom != 0)
    val gcd = greatestCommonDenominator(num, denom)
    val n = num / gcd
    val d = denom / gcd

    override def toString() = {n+"/"+d}
    override def equals(other: Any) = {
      other match {
        case that: Rational => this.n == that.n && this.d == that.d
        case _ => false
      }
    }

    private def greatestCommonDenominator(a: Int, b: Int): Int = {
        if (b == 0) a else greatestCommonDenominator(b, a % b)
    }
}
