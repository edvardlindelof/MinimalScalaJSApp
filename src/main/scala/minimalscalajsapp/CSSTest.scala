package minimalscalajsapp

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._


object CSSTest {
  def apply(): ReactElement = component()
  private val component = ReactComponentB[Unit]("CSSTest")
    .render(_ => theDiv)
    .build

  private val theDiv = <.div(
    <.div(
      ^.className := ExampleCSS.bacon.htmlClass,
      "i am a div and i am safely choosing my own class name"
    ),

    <.div(
      ^.className := "food-bacon",
      "i am a loose cannon div, choosing my class name with a literal"
    ),

    <.div(
      ^.className := ExampleCSS.eggs.htmlClass,
      ^.className := ExampleCSS.bold.htmlClass,
      "i am a div with two class names"
    ),

    <.h1(
      ^.className := ExampleCSS.baconAndEggs.htmlClass,
      "i am an animated header"
    )
  )
}
