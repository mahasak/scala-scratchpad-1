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
      it("should add a single-digit number") { calc.add("1") should be (1) }
      it("should add a double-digit number") { calc.add("10") should be (10) }
      it("should add numbers seperated by commas") { calc.add("1,10") should be (11) }
      it("should still work if there is a trailing commas") { calc.add("1,") should be (1) }
      it("should still work if there is a leading commas") { calc.add(",1") should be (1) }
      it("should return zero for a string with just a comma") { calc.add(",") should be (0) }
    }

    describe("when given a string separated by newlines") {
      it("should add numbers seperated by a newline") { calc.add("1\n10") should be (11) }
    }

    describe("when given a string separated by a mixture of newlines and commas") {
      it("should add numbers seperated by a newline and a comma") { calc.add("1\n10,2") should be (13) }
    }

    describe("when given a string specifying a new default delimiter on the first line") {
      it("should work when ';' is specified and numbers are separated by ','") { calc.add("//;\n1,10") should be (11) }
      it("should work when ';' is specified and numbers are separated by '\\n'") { calc.add("//;\n1\n10") should be (11) }
      it("should work when ';' is specified and numbers are separated by ';'") { calc.add("//;\n1;10") should be (11) }
      it("should work when '+' is specified and numbers are separated by '+'") { calc.add("//+\n1+10") should be (11) }
    }

    describe("when given one or more a negative numbers to add") {
      it("should throw an exception with just one number") {
        val thrown = evaluating { calc.add("-1") } should produce [IllegalArgumentException]
        thrown.getMessage should be ("negatives not allowed: [-1]")
      }
      it("should throw an exception with two negative numbers") {
        val thrown = evaluating { calc.add("-1,-2") } should produce [IllegalArgumentException]
        thrown.getMessage should be ("negatives not allowed: [-1,-2]")
      }
      it("should throw an exception with two negative numbers and one positive") {
        val thrown = evaluating { calc.add("10,-1,-2") } should produce [IllegalArgumentException]
        thrown.getMessage should be ("negatives not allowed: [-1,-2]")
      }
    }
    
    describe("when numbers are bigger than 1000, they should be ignored") {
      it("should add two numbers with one greater than 1000 and only return the smaller") {calc.add("2,1001") should be (2) }
      it("should add three numbers with one greater than 1000 and return the correct sum") {calc.add("2,1001,3") should be (5) }
      it("should return 0 if the only number is greater than 1000") {calc.add("1001") should be (0) }
    }
    
    describe("allows delimiters of any length to be specified") {
      it("should use a delimiter of two characters when supplied") {calc.add("//**\n1**2") should be (3)} 
    }
  }
}
