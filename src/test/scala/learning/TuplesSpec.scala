package learning

import org.scalatest.Spec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TuplesSpec extends Spec with ShouldMatchers {
    describe("Using tuples") {
      val t = (1, "one", new java.util.Date())
      it("is possible to create and access elements of a tuple") {
        t._1 should be (1)
        t._2 should be ("one")
        t._3 should not be (null)
      }
      it("is not possible to modify the contents of a tuple") {
        //t.1 = 2  - doesn't compile
      }
    }
}