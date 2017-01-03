package minimalscalajsapp

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js.Dynamic.global
import scala.scalajs.js
import org.scalajs.dom.console

object DraggableTest {
  def apply(): ReactElement = component()
  private val component = ReactComponentB[Unit]("CSSTest")
    .render(_ => theDiv)
    .build

  def say(text: String): Callback = Callback(
    println(text)
  )

  def preventDefaultHandling(desc: String)(e: ReactEventI): Callback = {
    // this needs to be called by onDragOver for onDrop to work.
    // the internet said so
    Callback(e.preventDefault())
  }

  def dragWithData(desc: String)(data: String)(e: ReactEventI): Callback = {
    Callback({
      println(desc)
      println(data) // prints the extra data included
      console.log(e.target) // prints the html element of the target
    })
  }

  def onDrop(desc: String)(e: ReactEventI): Callback = {
    Callback({
      println(desc)
      console.log(e.target) // prints the html of the target
    })
  }

  private val theDiv = <.div(
    <.div(
      ^.draggable := "True",
      ^.onDragStart --> say("A: onDragStart"),
      ^.onDragEnd --> say("A: onDragEnd"),
      "A: i am draggable"
    ),

    <.div(
      "B: i am not draggable or a drop zone or anything"
    ),

    <.div(
      ^.onDragOver ==> preventDefaultHandling("C: onDragOver"),
      ^.onDragEnter --> say("C: onDragEnter"),
      ^.onDragLeave --> say("C: onDragLeave"),
      ^.onDrop ==> onDrop("C: onDrop"),
      "C: i am a drop zone"
    ),

    <.div(
      ^.draggable:="True",
      ^.onDrag --> say("D: onDrag"),
      "D: i trigger onDrag"
    ),

    <.div(
      ^.draggable:="True",
      ^.onDragOver --> say("E: onDragOver"),
      "E: i trigger on onDragOver"
    ),
    
    <.div(
      ^.draggable:="True",
      ^.onDragStart ==> dragWithData("F: onDrag")("F was selected"),
      "F: My data is included when dragging"
    )
  )
}
