import sbt._ 
import templemore.sbt.CucumberProject

class TheProj(info: ProjectInfo) extends DefaultProject(info) with CucumberProject {

  val scalaToolsSnapshots = ScalaToolsSnapshots

  val scalatest = "org.scalatest" % "scalatest" %  "1.3" % "test"
  val specs = "org.scala-tools.testing" %% "specs" %  "1.6.6" % "test"
}
