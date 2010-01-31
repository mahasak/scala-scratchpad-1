package learning

import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Spec}

@RunWith(classOf[JUnitRunner])
class SimpleParameterSpec extends Spec with ShouldMatchers {

  describe("A SimpleParameter") {
    describe("(when empty)") {
      val person = new SimpleParameterObject("Tony", "Baines")
      it("should be populated and immutable") {
        person.firstName should be ("Tony")
        person.lastName  should be ("Baines")
        // person.firstName = "Bob"           "compile fails with error:reassignment to val"
      }
    }
  }
}