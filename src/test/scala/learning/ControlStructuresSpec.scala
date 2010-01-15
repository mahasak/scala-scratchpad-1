package learning

import org.scalatest.Spec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ControlStructuresSpec extends Spec with ShouldMatchers {
    describe("Scala has a small set of control structures") {
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
      it("'for' loops can include multiple generators") {
        var result = 0
        val data = List(1 to 3, 1 to 3)
        for (i <- data; j <- i) result += j
        result should be (12)
      }
      it("'for' loops can use 'yield' before the body to return a new collection") {
        // The 'body' of the loop is the expression 'i' here
        // 2.8 (for {i <- 1 to 3} yield i) should be (List(1,2,3))
      }
      it("'match' expressions break by default (no fall through)") {
        ("Hello" match {
            case "Hello" => true
            case _ => false
        }) should be (true)
      }
    }
}