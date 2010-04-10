package actors

import scala.actors._
import java.io._

class FilesystemWalker() extends Actor {
  def act() = {
    react {
      case (path: String, callback: Actor) => {
        walkAndNotify(path, callback)
        callback ! "END"
      }
    }
  }
  
  private def walkAndNotify(path: String, callback: Actor) {
    val res = new File(path)
    if (res.isFile) {
      callback ! path
    }
    else {
      res.listFiles.foreach { child =>
        walkAndNotify(child.getAbsolutePath, callback)
      }
    }
  }
}
  