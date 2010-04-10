package actors

import scala.actors._

class LocCounter() extends Actor {
  def act = {
    react {
      case (filename: String, whoToTell: Actor) => {
        whoToTell ! (filename, scala.io.Source.fromFile(filename).getLines.toList.length)
      }
    }
  }
}