enablePlugins(ScalaJSPlugin)

name := "Minimal ScalaJS App"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.github.japgolly.scalajs-react" %%% "core" % "0.11.3",
  "org.singlespaced" %%% "scalajs-d3" % "0.3.3"
)

jsDependencies ++= Seq(

  "org.webjars.bower" % "react" % "15.3.2"
    /        "react-with-addons.js"
    minified "react-with-addons.min.js"
    commonJSName "React",

  "org.webjars.bower" % "react" % "15.3.2"
    /         "react-dom.js"
    minified  "react-dom.min.js"
    dependsOn "react-with-addons.js"
    commonJSName "ReactDOM",

  "org.webjars" % "jquery" % "2.1.4"
    / "jquery.js"
    minified "jquery.min.js",
    
  // css imported in html
  "org.webjars" % "bootstrap" % "3.3.7"
    / "bootstrap.js"
    minified "bootstrap.min.js"
    dependsOn "jquery.js"
)
