package example

import org.scalatest.Spec
import org.scalatest.matchers._
import scala.collection.mutable.Stack
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BDDStackSpec extends Spec with ShouldMatchers {

  describe("A Stack") {

    describe("(when empty)") {

      val stack = new Stack[Int]

      it("should be empty") {
        stack should be ('empty)
      }

      it("should complain when popped") {
        evaluating { stack.pop() } should produce [NoSuchElementException]
      }
    }
  }
}