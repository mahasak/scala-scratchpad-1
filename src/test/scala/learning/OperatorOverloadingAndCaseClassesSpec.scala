package learning

import org.scalatest.Spec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class OperatorOverloadingAndCaseClassesSpec extends Spec with ShouldMatchers {
    describe("Using case-classes to represent an outcome") {
      val wrong = Wrong
      val right = Right
      val hmmm = Hmmm
      it("should be clear that two wrongs don't make a right") {
        (wrong+wrong) should not be (right)
        (wrong+wrong) should be (wrong)
      }
      it("should be clear that two rights don't make a wrong") {
        (right+right) should not be (wrong)
        (right+right) should be (right)
      }
      it("should be less certain when things aren't black-and-white") {
        (right+wrong) should be (hmmm)
        (hmmm+hmmm) should be (hmmm)
      }
      it("makes sense that uncertainty is easily resolved") {
        (right+hmmm) should be (right)
        (wrong+hmmm) should be (wrong)
      }

    }
}

abstract class Outcome() {}

/*
 * case-classes/objects allow the class to be used in a match block
 */
case object Wrong extends Outcome {
  def +(that: Outcome): Outcome = {
    that match {
      case Right => Hmmm
      case _ => this
    }
  }
}

case object Right extends Outcome {
  def +(that: Outcome): Outcome = {
    that match {
      case Wrong => Hmmm
      case _ => this
    }
  }
}

case object Hmmm extends Outcome {
  def +(that: Outcome): Outcome = that
}