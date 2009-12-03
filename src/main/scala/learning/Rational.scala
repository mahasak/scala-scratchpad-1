package learning

class Rational(val num: Int, val denom: Int) {
    require (denom != 0)
    val gcd = greatestCommonDenominator(num, denom)
    val n = num / gcd
    val d = denom / gcd

    def this(num: Int) = {this(num,1)}

    override def toString() = {
      n + (if (d>1) ("/" + d) else "")
    }
    override def equals(other: Any) = {
      other match {
        case that: Rational => this.n == that.n && this.d == that.d
        case _ => false
      }
    }
    override def hashCode = {this.n*this.d}

    def /(other: Rational) = {
        new Rational((this.n*other.d), ((this.d*other.n)))
    }
    def *(other: Rational) = {
        new Rational((this.n*other.n), ((this.d*other.d)))
    }
    def +(other: Rational) = {
      new Rational(((this.n*other.d)+(other.n*this.d)), (this.d*other.d))
    }
    def -(other: Rational) = {
        new Rational(((this.n*other.d)-(other.n*this.d)), (this.d*other.d))
    }

    private def greatestCommonDenominator(a: Int, b: Int): Int = {
        if (b == 0) a else greatestCommonDenominator(b, a % b)
    }
}
