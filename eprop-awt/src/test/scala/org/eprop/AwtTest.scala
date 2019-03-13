
package org.eprop

import org.scalatest.{ FlatSpec, Matchers }
import org.eprop.EKey._
import org.eprop.EKeyAwt._

import java.awt.{ Color, Dimension, Font, Shape, Stroke, BasicStroke, Rectangle }

trait AwtTestFixture {

  object ColorPType extends EKeyType[Color]('color)
  object DimensionPType extends EKeyType[Dimension]('dimension)
  object FontPType extends EKeyType[Font]('font)
  object ShapePType extends EKeyType[Shape]('shape)
  object StrokePType extends EKeyType[Stroke]('stroke)

  // declare your extensible model type
  class Container(props: EProperty[_]*) extends Extensible {
    merge(props)

    def color: Option[Color] = get[Color](ColorPType)
    def dimension: Option[Dimension] = get[Dimension](DimensionPType)
    def font: Option[Font] = get[Font](FontPType)
    def shape: Option[Shape] = get[Shape](ShapePType)
    def stroke: Option[Stroke] = get[Stroke](StrokePType)
  }

  // now make an instant of your container with some values
  val rec: Shape = new Rectangle(0, 0, 20, 10)
  val str: Stroke = new BasicStroke(10)
  val container = new Container(
    Color.black as ColorPType, 
    new Dimension(10, 20) as DimensionPType,
    new Font("SansSerif", 0, 12) as FontPType, 
    rec as ShapePType, str as StrokePType)
}

class AwtTest extends FlatSpec with AwtTestFixture with Matchers {

  "The properties" should "handle awt types correctly" in {

    container.color should be(Some(Color.black))
    container.dimension should be(Some(new Dimension(10, 20)))
    container.font should be(Some(new Font("SansSerif", 0, 12)))
    container.shape should be(Some(new Rectangle(0, 0, 20, 10)))
    container.stroke should be(Some(new BasicStroke(10)))
  }
}
