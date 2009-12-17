package kata9


import org.scalatest.Spec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CheckOutSpec extends Spec with ShouldMatchers {
    val RULES = Map(
        "A" -> (50, "")
    )
    describe("A supermarket check-out") {
      val co = new CheckOut(RULES)
      it("should begin a transaction with zero cost") {
        co.total() should be (0)
      }
      it("should add the cost of each item scanned") {
        co.scan("A")
        co.total() should be (50)
        co.scan("A")
        co.total() should be (100)
      }
    }
}
