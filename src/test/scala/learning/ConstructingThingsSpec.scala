package learning

import org.scalatest.Spec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ConstructingThingsSpec extends Spec with ShouldMatchers {
    // Spot the magic properties
    class Miscelany(val number: Int, val text: String) {
      // Overloaded constructor
      def this(number: Int) = this(number, "default")
    }

    describe("Building an instance using all of the available constructor parameters") {
      val misc = new Miscelany(1, "One")
      it("will have both properties initailsed explicitly") {
        misc.number should be (1)
        misc.text should be ("One")
      }
    }

    describe("Building an instance using an overloaded constructor") {
      val misc = new Miscelany(2)
      it("will have both properties initailsed according to the overloaded implementation") {
        misc.number should be (2)
        misc.text should be ("default")
      }
    }
}
