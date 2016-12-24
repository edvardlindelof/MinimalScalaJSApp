package minimalscalajsapp

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object WidgetInjectionTest {
  def apply(): ReactElement = component()
  private val component = ReactComponentB[Unit]("WidgetInjectionTest")
    .initialState(State(PlaceholderComp()))
    .renderBackend[Backend]
    .build

  //type Comp = ReactComponentU[Unit, Unit, Unit, Element]
  case class State(component: ReactElement)

  class Backend($: BackendScope[Unit, State]) {
    def changeState(element: ReactElement): Callback = $.setState(State(element))
    def render(s: State) =
      <.div(
        s.component,
        <.button(
          "fetch sp-example-widget.js",
          ^.onClick --> Callback.future(fetchAndSwitchComp())
        )
      )

    def fetchAndSwitchComp(): Future[Callback] = {
      // this should maybe actually be a singleton
      val componentLoaderService = new ComponentLoaderService()

      // trying out the loader, for now using a hard link
      componentLoaderService.fetchFactory(
        "http://localhost:8000/sp-example-widget.js", "TestWidget")
        .map(CompFactory => {
              val widget = CompFactory(WrapObj(Unit))
              //val widgetWrapper = new WidgetWrapper(widget)
              changeState(widget)
            }
        )
      }
    }

  val placeholderText: String = "This is a placeholder component. " +
    "To replace it with sp-simple-widget, a component unknown to this app so far, " +
    "serve it with http-server -p 8000 --cors sp-simple-widget " +
    "(having installed it with npm install http-server -g), then press fetch."
  val PlaceholderComp = ReactComponentB[Unit]("PlaceholderComp")
    .render(_ => <.h4(placeholderText))
    .build
}
