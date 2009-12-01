package learning

import org.scalatest.Spec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MapSpec extends Spec with ShouldMatchers {
    describe("Using an immutable Map") {
      var m = Map(1 -> "I")
      it("getting contents returns an Optional") {
        m.get(1) should be (Some("I"))
        m.get(2) should be (None)
      }
      it("adding contents is possible, if the instance is a 'var'") {
        m += (2 -> "II")
        m.get(2) should be (Some(("II")))
      }
      it("the '->' method is available on all objects and returns a Tuple") {
        (1 -> "II") should be ((1, "II"))
        1.->("II") should be ((1, "II"))
      }
    }

    describe("Using a mutable map") {
        val m = scala.collection.mutable.Map(1 -> "I")
        it("adding contents is possible, even if the instance is a 'val'") {
          m += (2 -> "II")
          m.get(2) should be (Some(("II")))
        }
    }
}