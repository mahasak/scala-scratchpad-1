package learning

import org.scalatest.Spec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FunctionsSpec extends Spec with ShouldMatchers {
    describe("Function literals can be used anonymously") {
      var result1 = ""
      var result2 = ""
      val arr = Array(1,2,3)

      // function-literal is '(e: Int) => result += e'
      arr.foreach((e: Int) => result1 += e)
      arr.foreach(e => result2 += e) // Inferred type

      it("both forms should yield the same result") {
        result1 should be ("123")
        result2 should be (result1)
      }
    }
}