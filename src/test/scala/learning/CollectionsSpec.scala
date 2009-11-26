package learning

import org.scalatest.Spec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CollectionsSpec extends Spec with ShouldMatchers {
    describe("Using Lists") {
      val emptyList = List()
      it("is possible to build Lists using the infix operator '::'") {
        (1 :: emptyList) should be (List(1))
        (2 :: 1 :: emptyList) should be (List(2,1))
        emptyList should be ('empty)
      }
    }
    describe("Initialising empty Array of Ints") {
      val arr = new Array[Int](3)
      it("will be filled with default Ints") {
          arr should be (Array(0, 0, 0))
      }
    }
    describe("Initialising an Array of Ints") {
      val arr = Array(1,2,3)
      it("will be initialised as specified") {
          arr(0) should be (1)
          arr(1) should be (2)
          arr(2) should be (3)
      }
    }
    describe("Accessing Arrays") {
      val arr1 = Array(1,2,3)
      val arr2 = new Array[String](3)
      it("uses 'apply' method calls to read") {
        arr1(0) should be (arr1.apply(0))
      }
      it("uses 'update' method calls to write") {
        arr2(0) = "Hello"
        arr2(0) should be ("Hello")
        arr2.update(0, "Bonjour")
        arr2(0) should be ("Bonjour")
      }
    }
}