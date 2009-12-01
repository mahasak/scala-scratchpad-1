package learning

import org.scalatest.Spec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ClassesAndObjectsSpec extends Spec with ShouldMatchers {
    describe("Access permissions in Scala") {
      class SimpleClass {
        // Variables must be initialised or be considered abstract
        private var a = ""
        var b = ""
      }
      it("the default access permission is public") {
        val c = new SimpleClass
        c.b = "Hello"
        c.b should be ("Hello")
        // c.a = "Hi" - Doesn't compile
      }
    }

    describe("Methods/functions") {
      it("parameters are final") {
        def func(s: String): Unit = {
          // s = "Hi" - Doesn't compile 'reassignment to val'
        }
        true
      }
      it("return type Unit will discard return-values") {
        def func(): Unit = {
          "Hello"
        }
        func should not be ("Hello")
      }
      it("methods declared in the procedureal style (without '='') have Unit return type") {
        def func() {
          "Hello"
        }
        func should not be ("Hello")
      }
      it("return types can be inferred for the functional style") {
        def func() = {
          "Hello"
        }
        func should be ("Hello")
      }
    }

    describe("Singleton objects provide similar features to statics in Java") {
      // See Singleton.scala
      it("access through the object name") {
        Singleton.name should be ("Tony")
      }
      it("a class of the same name is called a 'companion class' and has access to private members of the object") {
        val s = new Singleton
        s.age should be (39)
      }
    }
}