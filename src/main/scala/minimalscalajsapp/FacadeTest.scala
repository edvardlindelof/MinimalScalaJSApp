package minimalscalajsapp

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scalajs.js
import scalajs.js.annotation.JSName

object FacadeTest {
  def apply() = component()
  private val component = ReactComponentB[Unit]("FacadeTest")
    .render(_ => <.h2("Hello from FacadeTest"))
    .componentDidMount(_ => Callback(println(PointlessJSFunctions.funcB("Ost"))))
    .build
}

@JSName("pointlessJSFunctions")
@js.native
object PointlessJSFunctions extends js.Object {
  def funcA(): String = js.native
  def funcB(str: String): String = js.native
}
