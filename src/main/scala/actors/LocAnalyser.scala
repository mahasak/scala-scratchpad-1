package actors

import scala.actors._

class LocAnalyser(path: String, walker: FilesystemWalker, accumulator: ResultAccumulator) extends Actor {
  private var running = true
  
  def act() = {
    println("Here we go")
    val workerPool = List[LocCounter]()
    walker ! (path, this)
    while(true) {
      receive {
        case "END" => {
          println("Winding up")
          while(workerPool.exists {_.running}) {
            println("Waiting for the workers to finish")
            Thread.sleep(500)
          }
          accumulator ! "END"
          while(accumulator processing) {
            println("Waiting for the accumulator to finish")
            Thread.sleep(500)
          }
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
      Thread.sleep(500)
    }
    println("Ready to return a result")
    accumulator.result
  }
}