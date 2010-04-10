package actors

import scala.actors._

class ResultAccumulator() extends Actor {
  private var running = true
  private var started = false
  private var min = ("", Integer.MAX_VALUE)
  private var max = ("", 0)
  
  def act = {
    while(true) {
      receive {
        case "END" => running = false
        case (filename: String, loc: Int) => started = true; analyse(filename, loc)
      }
    }
  } 
  
  def analyse(filename: String, loc: Int) {
    println("Analysing " + filename)
    if (loc < min._2) min = (filename, loc)
    if (loc > max._2) max = (filename, loc)
  }
  
  def processing = !(started && !running)
  
  def result = {
    Result(min, max)
  }
}