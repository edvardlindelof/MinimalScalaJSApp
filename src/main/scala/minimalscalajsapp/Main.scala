package minimalscalajsapp

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom.document
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import com.karasiq.bootstrap4.navbar

import MyStyles._

object Main extends JSApp {

  @JSExport
  def main(): Unit = {
    println("printed with println")
    ReactDOM.render(RootComp(), document.getElementById("AppRoot"))
  }

  case class State(component: ReactElement)

  class Backend($: BackendScope[Unit, State]) {
    def changeState(s: ReactElement): Callback = $.setState(State(s))
    def render(p: Unit, s: State) =
      <.div(
        <.nav(
          ^.className := "navbar navbar-expand-lg navbar-light bg-light",
          <.div(
            ^.className := "collapse navbar-collapse",
            <.div(
              ^.className := "navbar-nav",
              MenuButton("Comp A", SomeComp()),
              MenuButton("Comp B", SomeOtherComp()),
              MenuButton("Facade Test", FacadeTest()),
              MenuButton("json Editor Test", JSONEditorTest()),
              MenuButton("Widget Injection Test", WidgetInjectionTest()),
              MenuButton("D3 Test", D3Test()),
              MenuButton("CSS Test", CSSTest()),
              MenuButton("Draggable Test", DraggableTest())
            ))),
        s.component
      )

    object MenuButton {
      def apply(text: String, element: ReactElement): ReactElement =
        component(MenuBtnProps(text, element))
      case class MenuBtnProps(text: String, element: ReactElement)
      val component = ReactComponentB[MenuBtnProps]("MenuButton")
        .render_P(p => <.a(p.text,
                            ^.className := "nav-item nav-link",
                            ^.onClick --> changeState(p.element),
                            ))
        .build
    }
  }

  val RootComp = ReactComponentB[Unit]("Example")
    .initialState(State(SomeComp()))
    .renderBackend[Backend]
    .build

  val SomeComp = ReactComponentB[Unit]("SomeComp")
    .render_P(_ => <.h2("Hello from SomeComp"))
    .build

  val SomeOtherComp = ReactComponentB[Unit]("SomeOtherComp")
    .render_P(_ => <.h2("Hello from SomeOtherComp"))
    .build

}
