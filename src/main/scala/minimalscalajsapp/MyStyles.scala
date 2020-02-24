package minimalscalajsapp

import scalacss.Defaults._

object MyStyles extends StyleSheet.Inline {
  import dsl._

  // TODO consider removing all three
  // they're unused atm because the amount of coupling between this and the main file doesnt feel practical
  val myNavStyle = style(addClassNames("navbar", "navbar-static-top", "navbar-default"))
  val myNavListSTyle = style(addClassNames("nav", "navbar-nav"))
  val MyButtonStyle = style(addClassNames("btn", "navbar-btn"))

}
