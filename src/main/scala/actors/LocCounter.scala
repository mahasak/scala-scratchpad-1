package actors

import scala.actors._

class LocCounter() extends Actor {
  var running = true
  def act = {
    react {
      case (filename: String, whoToTell: Actor) => {
        Thread.sleep(1500) // Introduce a delay to simulate work
        whoToTell ! (filename, scala.io.Source.fromFile(filename).getLines.toList.length)
      }
    }
    running = false
  }
}