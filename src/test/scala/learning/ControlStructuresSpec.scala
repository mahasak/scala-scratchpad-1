package learning

import org.scalatest.Spec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ControlStructuresSpec extends Spec with ShouldMatchers {
    describe("Scala has a smallset of control structures") {
      it("'if' blocks return a value") {
        val result =
          if (1>2) true else false
        result should be (false)
      }
      it("'while' and 'do-while' loops aren't expressions, and return 'Unit'") {
        var i=10
        while(i > 0) {
          i-=1
        } should be ()

        (do {
          i +=1
        } while (i < 10) ) should be ()
      }
      it("'for' loops can be used to iterate over collections") {
        var result = 0
        for (i <- List(1,2,3)) result += i
        result should be (6)
      }
      it("'for' loops can be used to iterate over ranges") {
          var result = 0
          for (i <- 1 to 3) result += i
          result should be (6)
      }
      it("'for' loops can be used with one or more filter clauses") {
          var result = 0
          for (i <- 1 to 3; if (i>1); if (i<3)) {
               result += i
          }
          result should be (2)
      }
    }
}