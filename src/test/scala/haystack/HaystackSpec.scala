package haystack

import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FeatureSpec, Spec, GivenWhenThen}

@RunWith(classOf[JUnitRunner])
class HaystackSpec extends FeatureSpec with GivenWhenThen with ShouldMatchers {
  
  feature("Needle in a Haystack") {
    scenario("Finding a needle") {
      given("a haystack")
        val haystack = new Haystack("banananobano")
      when("the searching for needles")
        val matches = haystack.needles("na")
      then("the (zero-based) index of the matches should be printed in ascending order")
        matches should be(List(2, 4))
    }
    
    scenario("Finding no needles") {
      given("a haystack")
        val haystack = new Haystack("foo")
      when("the searching for needles")
        val matches = haystack.needles("foobar")
      then("the (zero-based) index of the matches should be printed in ascending order")
        matches should be(List())
    }
    
    scenario("Finding more needles") {
      given("a haystack")
        val haystack = new Haystack("barfoobarfoobarfoobarfoobarfoo")
      when("the searching for needles")
        val matches = haystack.needles("foobarfoo")
      then("the (zero-based) index of the matches should be printed in ascending order")
        matches should be(List(3,9,15,21))
    }
    
    scenario("Finding many needles") {
      given("a haystack")
        val haystack = new Haystack("aaaaaaaaaa")
      when("the searching for needles")
        val matches = haystack.needles("a")
      then("the (zero-based) index of the matches should be printed in ascending order")
        matches should be(List(0,1,2,3,4,5,6,7,8,9))
    }
  }
}
