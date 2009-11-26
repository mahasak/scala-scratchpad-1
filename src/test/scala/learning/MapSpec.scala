package learning

import org.scalatest.Spec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MySpec extends Spec with ShouldMatchers {
    describe("Using a Map") {
      var m = Map(1 -> "I")
      it("getting contents returns an Optional") {
        m.get(1) should be (Some("I"))
        m.get(2) should be (None)
      }
      it("adding contents is possible") {
        m += (2 -> "II")
        m.get(2) should be (Some(("II")))
      }
      it("the '->' method is available on all objects and returns a Tuple") {
        (1 -> "II") should be ((1, "II"))
        1.->("II") should be ((1, "II"))
      }
    }
}