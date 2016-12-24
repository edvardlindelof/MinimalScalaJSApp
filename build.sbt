enablePlugins(ScalaJSPlugin)

name := "Minimal ScalaJS App"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.github.japgolly.scalajs-react" %%% "core" % "0.11.3",
  "com.github.japgolly.scalacss" %%% "core" % "0.5.1",
  "org.singlespaced" %%% "scalajs-d3" % "0.3.3",
  "fr.hmil" %%% "roshttp" % "2.0.0-RC1"
)

jsDependencies ++= Seq(
  ProvidedJS / "pointlessJSFunctions.js"
)
