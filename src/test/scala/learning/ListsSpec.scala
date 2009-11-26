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
    describe("Doing things with Lists") {
      val list = List(1,2,3,4,5,6)
      it("is possible to get the size") {list.length should be (6)}
      it("using count with a function to match") {list.count(i => i > 2) should be (4)}
      it("using drop to get part of the list") {list.drop(2) should be (List(3,4,5,6))}
      it("using dropRight to get part of the list") {list.dropRight(2) should be (List(1,2,3,4))}
      it("using exists with a function to check contents") {list.exists(i => i == 2) should be (true)}
      it("using filter with a function to get some contents") {list.filter(i => i > 2) should be (List(3,4,5,6))}
      it("using forall with a function to check contents") {list.forall(i => i < 7) should be (true)}
      it("using foreach with a function to do something with each element") {var result = ""; list.foreach(i => result +=i); result should be ("123456")}
      it("using head to get the first element") {list.head should be (1)}
      it("using last to get the last element") {list.last should be (6)}
      it("using init to get all but the last element") {list.init should be (List(1,2,3,4,5))}
      it("using tail to get all but the first element") {list.tail should be (List(2,3,4,5,6))}
      it("using isEmpty") {list.isEmpty should be (false)}
      it("using map with a function to create a new List") {list.map(i => i + 1) should be (List(2,3,4,5,6,7))}
      it("using mkString with a function to create a String") {list.mkString("-") should be ("1-2-3-4-5-6")}
      it("using remove with a function to create a sub List") {list.remove(i => i%3 != 0) should be (List(3,6))}
      it("using reverse to create a new List") {list.reverse should be (List(6,5,4,3,2,1))}
      it("using sort with a function to create a new List") {list.sort((a,b) => a > b) should be (List(6,5,4,3,2,1))}
    }
}