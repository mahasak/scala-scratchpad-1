package actors

object Factory {
  def locCounter(path: String): LocAnalyser = {
    val walker = new FilesystemWalker()
    walker.start()
    val accumulator = new ResultAccumulator()
    accumulator.start()
    
    val analyser = new LocAnalyser(path, walker, accumulator)
    analyser.start()
    analyser
  }
}
