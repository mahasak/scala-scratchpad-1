package learning

import org.scalatest.Spec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ListsSpec extends Spec with ShouldMatchers {
    describe("Initialising Lists") {
      val list = List(1,2,3)
      it("will be initialised as specified") {
        list(0) should be (1)
        list(1) should be (2)
        list(2) should be (3)
      }
    }
    describe("Lists are immutable") {
      val list = List(1,2,3)
      it("so you can't change their contents!") {
        //list(0) = 3  Does not compile
      }
    }
    describe("Building Lists") {
      val emptyList = Nil // shorthand for List()
      it("is possible to build Lists using the infix operator '::' (aka 'cons') to create a new List") {
        // N.B. :: operates on the RHS (- )as does any operator ending with a colon)
        // and pushes to the head of the List (a constant time operation)
        (1 :: emptyList) should be (List(1))
        (emptyList.::(1).::(2)) should be (List(2,1))
        emptyList should be ('empty)
      }
      it("is possible to join Lists using the concatenate operator ':::' to create a new List") {
        (List(1) ::: emptyList) should be (List(1))
        (List(2) ::: List(1) ::: emptyList) should be (List(2,1))
        emptyList should be ('empty)
      }
    }
}