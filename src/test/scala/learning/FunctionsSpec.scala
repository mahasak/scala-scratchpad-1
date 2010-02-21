package learning

import org.scalatest.Spec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FunctionsSpec extends Spec with ShouldMatchers {
    describe("Function literals can be used anonymously") {
      val arr = Array(1,2,3)
      var result1 = ""
      var result2 = ""

      // function-literal is '(e: Int) => result += e'
      arr.foreach((e: Int) => result1 += e)
      arr.foreach(e => result2 += e) // Inferred type

      it("and both forms should yield the same result") {
        result1 should be ("123")
        result2 should be (result1)
      }
      it("and placeholder syntax can be used to reduce boilerplate further") {
        arr.filter(_>2) should be (Array(3))
      }
    }
    describe("Partially applied functions use the placeholder syntax") {
      def sum(a: Int, b: Int, c: Int) = a+b+c
      val plusTwo = sum(2, _: Int, _: Int)
      val plusThree = sum(2, 1, _: Int)
      val aliasedSum = sum _

      it("to replace zero, one or more arguments and reduce duplication") {
        plusTwo(2, 0) should be (4)
        plusThree(2) should be (5)
        aliasedSum(1,2,3) should be (6)
      }
      it("and where a function is expected the placeholder can be ommitted") {
          val someNumbers = List(1,2,3)
          someNumbers.map(plusThree(_)) should be (List(4,5,6))
          someNumbers.map(plusThree) should be (List(4,5,6))
      }
    }
    describe("Currying is similar to partially applied functions") {
      it("it allows replacement of an argument") {
        def sum(a: Int)(b: Int) = a+b
        val plusTwo = sum(2)_
        plusTwo(3) should be (5)
      }
      it("it enables the use of '{...}' as an argument") {
        def doStuff(a: Int)(stuff: Int => Int) = stuff(a)
        // Curly-brace syntax only valid for a function with one argument
        (doStuff(2){
          _ * 2
        }) should be (4)
        (doStuff(2){
            _ / 2
        }) should be (1)
      }
    }
    describe("Closures are functions that make use of a free variable") {
      var free = 0
      val timesFree = (x: Int) => free * x

      it("invoking the closure uses the current value of the free variable") {
         timesFree(2) should be (0)
         free = 1
         timesFree(2) should be (2)
      }
    }
    describe("Repeated arguments are defined with a '*'") {
      def consultant(args: String *) = {
        "You have: " + args.mkString(",")
      }
      it("and can be used with a variable number of arguments") {
        consultant("Pigs", "Chickens") should be ("You have: Pigs,Chickens")
        consultant("Pigs", "Chickens", "Talking chickens") should be ("You have: Pigs,Chickens,Talking chickens")
      }
      it("although repeated arguments are represented as Arrays it needs a special syntax to pass in an Array") {
        val myStuff = Array("Pigs", "Chickens")
        consultant(myStuff: _*) should be ("You have: Pigs,Chickens")
      }
    }
    describe("Tail recursion is optimised to use a single stack frame instead of many") {
      def sumTo(max: Int): Int = if(max == 0) 0 else max + sumTo(max - 1)
      it("which is only possible if the recursive call is the last thing in the function body") {
          sumTo(3) should be (6)
      }
    }
}
