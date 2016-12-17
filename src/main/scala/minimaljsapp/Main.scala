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
    // TODO put some root component in here
    ReactDOM.render(<.h1("GoudaOst"), document.getElementById("AppRoot"))
  }

}
