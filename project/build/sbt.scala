import sbt._

class ScalaScratchpadProject(info: ProjectInfo) extends DefaultProject(info) {
val scalatest = "org.scalatest" % "scalatest" % "1.0"
val junit = "junit" % "junit" % "4.7"
//val mavenLocal = "Local Maven Repository" at 
//"file://"+Path.userHome+"/.m2/repository"
}
