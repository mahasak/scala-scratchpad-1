package learning

import org.scalatest.Spec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class LoopsAndControlSpec extends Spec with ShouldMatchers {
    describe("A simple 'for' loop") {
      var result = ""
      for (val i <- 1 to 9)
          result += i
      it("should execute the body with each iteration") {
        result should be ("123456789")
      }
    }
    describe("A 'for' loop with a filter clause") {
      var result = ""
      for (val i <- 1 to 10; (i%3 == 0))
          result += i
      it("should only execute the body when the filter condition is met") {
        result should be ("369")
      }
    }
    describe("A 'for' loop with a filter clause which does something, but returns a boolean") {
      var result = ""
      def doStuff(i: Int): Boolean = {
        // Do anything
        true
      }
      for (val i <- 1 to 9; doStuff(i))
          result += i
      it("should only execute the body when the filter condition is met") {
        result should be ("123456789")
      }
    }
}