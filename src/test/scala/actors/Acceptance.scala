package actors

import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.MustMatchers
import scala.collection.mutable.Stack
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import scala.concurrent.ops._

@RunWith(classOf[JUnitRunner])
class Acceptance extends FeatureSpec with GivenWhenThen with MustMatchers {

  feature("I can get a measure of the lines of code in a directory") {

    scenario("processing a directory with Scala source code") {

      given("an analyser")
      val analyser = Factory.locCounter("src/")
      val analysis = future(analyser.results)

      when("when the result is ready")
      val result = analysis()

      then("the source file with most lines of code must be found")
      result.max._1 must be (new java.io.File("src/main/scala/haystack/Haystack.scala").getAbsolutePath)
      result.max._2 must be (116)
      
      and("the source file with least lines of code must be found")
      result.min._1 must be (new java.io.File("src/main/scala/learning/SimpleParameterObject.scala").getAbsolutePath)
      result.min._2 must be (3)
      
      and("The mean LoC must be found")
      result.meanLoc must be (36)
    }
  }
}