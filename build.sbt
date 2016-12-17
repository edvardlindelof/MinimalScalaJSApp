enablePlugins(ScalaJSPlugin)

name := "Minimal ScalaJS App"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.github.japgolly.scalajs-react" %%% "core" % "0.11.3"
)
