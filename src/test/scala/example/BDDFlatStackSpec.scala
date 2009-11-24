package example

import org.scalatest.FlatSpec
import org.scalatest.matchers._
import scala.collection.mutable.Stack
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BDDFlatStackSpec extends FlatSpec with ShouldMatchers {

  val stack = new Stack[Int]

  "A Stack (when empty)" should "be empty" in {
    stack should be ('empty)
  }

  it should "complain when popped" in {
    evaluating { stack.pop() } should produce [NoSuchElementException]
  }
}
