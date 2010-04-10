package actors

import scala.actors._

class ResultAccumulator() extends Actor {
  var min = ("", Integer.MAX_VALUE)
  var max = ("", 0)
  var totalLoc = 0
  var fileCount = 0
  def act = {
    while(true) {
      receive {
        case (filename: String, loc: Int) => analyse(filename, loc)
      }
    }
  } 
  
  def analyse(filename: String, loc: Int) {
    if (loc < min._2) min = (filename, loc)
    if (loc > max._2) max = (filename, loc)
    fileCount += 1
    totalLoc += loc
  }
  
  def result = {
    Result(this.min, this.max, (totalLoc/fileCount))
  }
}