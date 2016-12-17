package minimaljsapp

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom.document
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object Main extends JSApp {

  @JSExport
  def main(): Unit = {
    println("GoudaOst")
    ReactDOM.render(RootComp(), document.getElementById("AppRoot"))
  }

  // the type of our components after calling build
  type State = ReactComponentC.ConstProps[Unit, Unit, Unit, org.scalajs.dom.raw.Element]

  class Backend($: BackendScope[Unit, State]) {
    def changeState(s: State): Callback = $.setState(s)
    def render(s: State) =
      <.div(
        <.ul(
          <.li("CompA", ^.onClick --> changeState(SomeComp)),
          <.li("CompB", ^.onClick --> changeState(SomeOtherComp))),
        s()
      )
  }

  val RootComp = ReactComponentB[Unit]("Example")
    .initialState(SomeComp)
    .renderBackend[Backend]
    .build

  val SomeComp = ReactComponentB[Unit]("SomeComp")
    .render_P(_ => <.h2("Hello from SomeComp"))
    .build

  val SomeOtherComp = ReactComponentB[Unit]("SomeOtherComp")
    .render_P(_ => <.h2("Hello from SomeOtherComp"))
    .build

}
