package kata9

import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Acceptence extends FeatureSpec with GivenWhenThen with ShouldMatchers {
    val RULES = Map(
        "A" -> (50, "3 for 130"),
        "B" -> (30, "2 for 45"),
        "C" -> (20, ""),
        "D" -> (15, "")
    )

    feature("Supermarket Pricing") {
        scenario("Calculating a bill") {
          given("a basket of shopping")
          when("the discounts are applied")
          then("the total for the bill")
              price("") should be (0)
              price("A") should be (50)
              price("AB") should be (80)
              price("CDBA") should be (115)
              price("AA") should be (100)
              price("AAA") should be (130)
              price("AAAA") should be (180)
              price("AAAAA") should be (230)
              price("AAAAAA") should be (260)
              price("AAAB") should be (160)
              price("AAABB") should be (175)
              price("AAABBD") should be (190)
              price("DABABA") should be (190)

          and("the incremental cost")
              val co = new CheckOut(RULES)
              co.total() should be (0)
              co.scan("A"); co.total() should be (50)
              co.scan("B"); co.total() should be (80)
              co.scan("A"); co.total() should be (130)
              co.scan("A"); co.total() should be (160)
              co.scan("B"); co.total() should be (175)
        }
    }

    def price(goods: String) = {
      val co = new CheckOut(RULES)
      goods.split("").foreach { item => co.scan(item) }
      co.total
    }
}