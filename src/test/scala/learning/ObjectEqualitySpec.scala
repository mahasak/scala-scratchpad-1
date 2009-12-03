package learning

import org.scalatest.Spec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ObjectEqualitySpec extends Spec with ShouldMatchers {
    describe("Equality using '==' and '!='") {
      it("comparing simple types") {
        1 == 1 should be (true)
        2.0 == 2 should be (true)
        true != false should be (true)
        "Bob" == "Bob" should be (true)
      }
      it("comparing collection types") {
        List(1,2,3) == List(1,2,3) should be (true)
        Map(1 -> "One") == Map(1 -> "One") should be (true)
      }
      it("comparing completely different types will not cause a compilation error or runtime exception") {
        List(1,2,3) == "Bob" should not be (true)
      }
      it("comparing with 'null' will not cause a compilation error or runtime exception") {
        List(1,2,3) == null should not be (true)
        null == null should be (true)
      }
    }
}