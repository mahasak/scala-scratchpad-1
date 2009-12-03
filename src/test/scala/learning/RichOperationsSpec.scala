package learning

import org.scalatest.Spec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class RichOperationsSpec extends Spec with ShouldMatchers {
    describe("Using rich operations") {
      it("gives some literate code") {
        0 max 5 should be (5)
        0 min 5 should be (0)
        (-42 abs) should be (42)
        (3.1415 round) should be (3)
//        (1 to 5) should be (Range(1,2,3,4,5))
        (1 to 5).length should be (5)
        ((1.0/0) isInfinity) should be (true)
        ("tony baines" capitalize) should be ("Tony baines")
        ("12345" drop 3).toString should be ("45")
      }
    }
}