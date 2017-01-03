package minimalscalajsapp

import scalacss.Defaults._

object ExampleCSS extends StyleSheet.Inline {
  import dsl._

  val bacon = style("food-bacon")(
    backgroundColor.pink
  )

  val eggs = style("food-eggs")(
    backgroundColor.black
  )

  val bold = style("bold-text")(
    fontWeight.bold
  )

  // Keyframe animation example
  val baconAnimation = keyframes(
    (0 %%) -> eggs,
    (50 %%) -> bacon,
    (100 %%) -> eggs
  )

  val baconAndEggs = style("eggs-bacon")(
    animationDuration := "1s",
    animationIterationCount.infinite,
    animationName(baconAnimation)
  )

  
  this.addToDocument()
}
