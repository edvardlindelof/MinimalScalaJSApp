package minimaljsapp

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import org.singlespaced.d3js.d3
import org.singlespaced.d3js.Ops._
import scala.scalajs.js.{Array => JSArray}

object D3Test {
  private val d3divUglyCustomId = "d3divUglyCustomId"
  def apply() = component()
  private val component = ReactComponentB[Unit]("D3Test")
    .render(_ => d3div)
    .componentDidMount(_ => Callback(addTheD3(d3divUglyCustomId)))
    .build
  private val d3div = <.div(^.id := d3divUglyCustomId)

  private def addTheD3(elementId: String): Unit = {
    val graphHeight = 450
    val barWidth = 80
    val barSep = 10
    val frameHeight = 50
    val horizontalBarDistance = barWidth + barSep
    val barHeightMultiplier = graphHeight / frameHeight
    val c = d3.rgb("PaleVioletRed")

    val rectXFun = (d: Int, i: Int) => i * horizontalBarDistance
    val rectYFun = (d: Int) => graphHeight - d * barHeightMultiplier
    val rectHeightFun = (d: Int) => d * barHeightMultiplier
    val rectColorFun = (d: Int, i: Int) => c.brighter(i * 0.2).toString

    val svg = d3.select("#" + elementId).append("svg").attr("width", "100%").attr("height", "450px")
    val sel = svg.selectAll("rect").data(JSArray(49, 4, 12, 31, 36, 48, 17, 25))

    sel.enter()
      .append("rect")
      .attr("x", rectXFun)
      .attr("y", rectYFun)
      .attr("width", barWidth)
      .attr("height", rectHeightFun)
      .style("fill", rectColorFun)
  }
}
