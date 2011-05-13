import sbt._

class Proj(info: ProjectInfo) extends DefaultProject(info) {
  val scalatest = "org.scalatest" % "scalatest_2.9.0" % "1.4.1" % "test"
}
