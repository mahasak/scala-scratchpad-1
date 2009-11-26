package learning

import org.scalatest.Spec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SetSpec extends Spec with ShouldMatchers {
    describe("Using (default) immutable sets") {
      it("is possible to call '+' and get a *new* Set") {
        val s = Set(1,2,3)
        s + 4 should be (Set(1,2,3,4))
      }
      it("is possible to call '+=' and get a *new* Set") {
          var s = Set(1,2,3)
          (s += 4) // equivalent to s = s+4
          s should be (Set(1,2,3,4))
      }
    }
    describe("Using mutable sets") {
        it("is possible to call '+' to update") {
            val s = scala.collection.mutable.Set(1,2,3)
            s + 4
            s should be (Set(1,2,3,4))
        }
        it("is possible to call '+=' to update") {
            // N.B. a *val*
            val s = scala.collection.mutable.Set(1,2,3)
            (s += 4)
            s should be (Set(1,2,3,4))
        }
    }
}