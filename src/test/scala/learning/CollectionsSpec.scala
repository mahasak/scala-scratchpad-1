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
      it("is possible to concatenate Lists using the infix operator '::'") {
        (1 :: emptyList) should be (List(1))
        (2 :: 1 :: emptyList) should be (List(2,1))
        emptyList should be ('empty)
      }
    }
}