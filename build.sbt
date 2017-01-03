enablePlugins(ScalaJSPlugin)

name := "Minimal ScalaJS App"

scalaVersion := "2.11.8"

val scalaCssVersion = "0.5.1"

libraryDependencies ++= Seq(
  "com.github.japgolly.scalajs-react" %%% "core" % "0.11.3",
  "com.github.japgolly.scalacss" %%% "core" % "0.5.1",
  "org.singlespaced" %%% "scalajs-d3" % "0.3.3",
  "fr.hmil" %%% "roshttp" % "2.0.0-RC1",
  "com.github.japgolly.scalacss" %%% "core" % scalaCssVersion,
  "com.github.japgolly.scalacss" %%% "ext-react" % scalaCssVersion
)

jsDependencies ++= Seq(
  ProvidedJS / "pointlessJSFunctions.js"
)
