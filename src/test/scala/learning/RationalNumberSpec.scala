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
      it("should be properly represented as a string") {
        oneHalf.toString should be ("1/2")
      }
      it("should be equal to another instance") {
        oneHalf should be (new Rational(1,2))
      }
      it("should not be equal to a different rational") {
        oneHalf should not be (new Rational(2,3))
      }
      it("should not be possible to use 0 as a denominator") {
        evaluating {new Rational(1, 0)} should produce [IllegalArgumentException]
      }
      it("should be normalised on creation") {
        new Rational(3,9).toString should be ("1/3")
        oneHalf should be (new Rational(2,4))
      }
    }
}