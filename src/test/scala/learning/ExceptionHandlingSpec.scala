package learning

import org.scalatest.Spec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import java.io.FileReader

@RunWith(classOf[JUnitRunner])
class ExceptionHandlingSpec extends Spec with ShouldMatchers {
    describe("Handling an exception with a catch block") {
      val isOpened: String =
	      try {
	          new FileReader("made-up-name")
	          "OPENED"
	      }
	      catch {
	          case ex: java.io.FileNotFoundException =>
	            "FNFE"
	          case ex: IllegalArgumentException =>
	            "IAE"
	      }
      it("should have caught the appropriate exception") {
        isOpened should be ("FNFE")
      }
    }

    describe ("Handling an exception in a Spec") {
      it("should complain when evaluating a bad call") {
        evaluating { new FileReader("made-up-name") } should produce [java.io.FileNotFoundException]
      }
    }
}
