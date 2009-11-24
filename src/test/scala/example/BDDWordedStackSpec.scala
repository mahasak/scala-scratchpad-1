package example

import org.scalatest.WordSpec
import org.scalatest.matchers._
import scala.collection.mutable.Stack
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BDDWordedStackSpec extends WordSpec with ShouldMatchers {

  "A Stack" when {

    "empty" should {

      val stack = new Stack[Int]

      "be empty" in {
        stack should be ('empty)
      }

      "complain when popped" in {
        evaluating { stack.pop() } should produce [NoSuchElementException]
      }
    }
  }
}
