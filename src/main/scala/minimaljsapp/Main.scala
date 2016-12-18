package minimaljsapp

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom.document
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom.raw.Element

object Main extends JSApp {

  @JSExport
  def main(): Unit = {
    println("GoudaOst")
    ReactDOM.render(RootComp(), document.getElementById("AppRoot"))
  }

  // the type of our components here
  type Comp = ReactComponentU[Unit, Unit, Unit, Element]

  class Backend($: BackendScope[Unit, Comp]) {
    def changeState(s: Comp): Callback = $.setState(s)
    def render(s: Comp) =
      <.div(
        <.nav(
          ^.className := "navbar navbar-static-top navbar-default",
          <.ul(
            ^.className := "nav_navbar-nav",
            MenuButton(MenuBtnProps("Comp A", SomeComp())),
            MenuButton(MenuBtnProps("Comp B", SomeOtherComp())),
            MenuButton(MenuBtnProps("Facade Test", FacadeTest())),
            MenuButton(MenuBtnProps("D3 Test", D3Test())))),
        s
      )
      case class MenuBtnProps(text: String, comp: Comp)
      val MenuButton = ReactComponentB[MenuBtnProps]("MenuButton")
        .render_P(p => <.li(p.text,
                            ^.onClick --> changeState(p.comp),
                            ^.className := "btn navbar-btn"))
        .build
  }

  val RootComp = ReactComponentB[Unit]("Example")
    .initialState(SomeComp())
    .renderBackend[Backend]
    .build

  val SomeComp = ReactComponentB[Unit]("SomeComp")
    .render_P(_ => <.h2("Hello from SomeComp"))
    .build

  val SomeOtherComp = ReactComponentB[Unit]("SomeOtherComp")
    .render_P(_ => <.h2("Hello from SomeOtherComp"))
    .build

}
