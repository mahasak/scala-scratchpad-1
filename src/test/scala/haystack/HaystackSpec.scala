package haystack

import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FeatureSpec, Spec, GivenWhenThen}

@RunWith(classOf[JUnitRunner])
class HaystackSpec extends FeatureSpec with GivenWhenThen with ShouldMatchers {
  val haystack = new Haystack()
  feature("Needle in a Haystack") {
    scenario("Finding a needle") {
      given("an containing needle and haystack")
      when("the search happens")
        val matches = haystack.needlesIn((2, "na", "banananobano"))
      then("the (zero-based) index of the matches should be printed in ascending order")
        matches should be(List(2, 4))
    }
    scenario("Finding no needles") {
      given("an containing needle and haystack")
      when("the search happens")
        val matches = haystack.needlesIn((6, "foobar", "foo"))
      then("the (zero-based) index of the matches should be printed in ascending order")
        matches should be(List())
    }
    scenario("Finding more needles") {
      given("an containing needle and haystack")
      when("the search happens")
        val matches = haystack.needlesIn((9, "foobarfoo", "barfoobarfoobarfoobarfoobarfoo"))
      then("the (zero-based) index of the matches should be printed in ascending order")
        matches should be(List(3,9,15,21))
    }
  }
}