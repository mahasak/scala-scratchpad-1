package calc

import org.scalatest.Spec
import org.scalatest.matchers._
import scala.collection.mutable.Stack
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class StringCalculatorSpec extends Spec with ShouldMatchers {

  describe("A String Calculator") {
    val calc = new StringCalculator()

    describe("when given a string separated by commas") {
      it("should return zero for an empty string") { calc.add("") should be (0) }
      it("should return 1 for a string with just 1") { calc.add("1") should be (1) }
      it("should return 10 for a string with just 10") { calc.add("10") should be (10) }
      it("should return 11 for a string with 1 & 10") { calc.add("1,10") should be (11) }
      it("should return 1 for a string with 1 followed by a comma") { calc.add("1,") should be (1) }
      it("should return 1 for a string with 1 preceeded by a comma") { calc.add(",1") should be (1) }
      it("should return zero for a string with just a comma") { calc.add(",") should be (0) }
    }

    describe("when given a string separated by newlines") {
      it("should return 11 for a string with 1 & 10 separated by a newline") { calc.add("1\n10") should be (11) }
    }

    describe("when given a string separated by a mixture of newlines and commas") {
      it("should return 13 for a string with 1,2 & 10 separated by a newline and a comma") { calc.add("1\n10,2") should be (13) }
    }

    describe("when given a string specifying a new default delimiter on the first line") {
      //it("should return 11 when ';' is specified and 1 & 10 are separated by ','") { calc.add("//;\n1,10") should be (11) }
      it("should return 11 when ';' is specified and 1 & 10 are separated by '\\n'") { calc.add("//;\n1\n10") should be (11) }
      it("should return 11 when ';' is specified and 1 & 10 are separated by ';'") { calc.add("//;\n1;10") should be (11) }
      it("should return 11 when '+' is specified and 1 & 10 are separated by '+'") { calc.add("//+\n1+10") should be (11) }
    }
  }
}
