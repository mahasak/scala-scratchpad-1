package actors

import scala.actors._

class LocAnalyser(path: String, walker: FilesystemWalker, accumulator: ResultAccumulator) extends Actor {
  private var running = true
  
  def act() = {
    val workerPool = List[LocCounter]()
    println("Here we go")
    walker ! (path, this)
    while(true) {
      receive {
        case "END" => {
          println("Winding up")
          running = false
        }
        case filename: String => {
          println("Adding a new worker for " + filename)
          val worker = new LocCounter()
          worker.start()
          worker :: workerPool
          worker ! (filename, accumulator)
        }
      }
    }
  }
  
  def results(): Result = {
    while(running) {
      Thread.sleep(1000)
    }
    accumulator.result
  }
}