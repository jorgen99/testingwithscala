import sbt._

class Plugins(info: ProjectInfo) extends PluginDefinition(info) {
  // http://skipoleschris.blogspot.com/2010/11/using-cucumber-with-scala-and-sbt.html
  val templemoreRepo = "templemore repo" at "http://templemore.co.uk/repo"
  val cucumberPlugin = "templemore" % "cucumber-sbt-plugin" % "0.4.1"
}
