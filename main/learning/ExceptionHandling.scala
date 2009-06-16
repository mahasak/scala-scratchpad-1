package learning

import java.io.FileReader

object ExceptionHandling  {
    def main(args: Array[String]): Unit = {
        // Simple case, note the assignment
        val isOpened: Boolean =
            try {
                new FileReader("made-up-name")
                true
            }
            catch {
                case ex: java.io.FileNotFoundException =>
	        false
            }
        assert (isOpened == false)
    }
  
}
