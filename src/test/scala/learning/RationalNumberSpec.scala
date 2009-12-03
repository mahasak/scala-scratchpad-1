package learning

import org.scalatest.Spec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class RationalNumberSpec extends Spec with ShouldMatchers {
    describe("A Rational Number") {
      val oneHalf = new Rational(1, 2)
      val twoThirds = new Rational(2,3)
      it("should be possible to simplify the instantiation of whole numbers") {
          new Rational(10) should be (new Rational(10,1))
          new Rational(0) should be (new Rational(0,1))
          new Rational(-10) should be (new Rational(-10,1))
      }
      it("should be properly represented as a string") {
          oneHalf.toString should be ("1/2")
          new Rational(10).toString should be ("10")
      }
      it("should be equal to another instance") {
        oneHalf should be (new Rational(1,2))
      }
      it("should not be equal to a different rational") {
        oneHalf should not be (twoThirds)
      }
      it("should not be equal to null") {
          oneHalf should not be (null)
      }
      it("should not be equal to an Int") {
          oneHalf should not be (1)
      }
      it("equal instances should have equal hascodes") {
        oneHalf.hashCode should be (new Rational(1,2).hashCode)
        twoThirds.hashCode should be (new Rational(2,3).hashCode)
      }
      it("should not be possible to use 0 as a denominator") {
        evaluating {new Rational(1, 0)} should produce [IllegalArgumentException]
      }
      it("should be normalised on creation") {
        new Rational(3,9).toString should be ("1/3")
        oneHalf should be (new Rational(2,4))
      }
      it("adding rational numbers") {
        oneHalf + oneHalf should be (new Rational(1))
        oneHalf + twoThirds should be (new Rational(7,6))
        twoThirds + twoThirds should be (new Rational(4,3))
      }
      it("subtracting rational numbers") {
          oneHalf - oneHalf should be (new Rational(0))
          oneHalf - twoThirds should be (new Rational(-1,6))
          twoThirds - twoThirds should be (new Rational(0))
      }
      it("multiplying rational numbers") {
          oneHalf * oneHalf should be (new Rational(1,4))
          oneHalf * twoThirds should be (new Rational(1,3))
          twoThirds * twoThirds should be (new Rational(4,9))
      }
      it("dividing rational numbers") {
          oneHalf / oneHalf should be (new Rational(1))
          oneHalf / twoThirds should be (new Rational(3,4))
          twoThirds / twoThirds should be (new Rational(1))
      }
    }
}