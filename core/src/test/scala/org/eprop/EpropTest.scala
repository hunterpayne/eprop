
package org.eprop

import org.scalatest.FlatSpec
import org.eprop.EKey._

class EpropTest extends FlatSpec {

  object ColorPType extends EKeyType[String]('color)
  object LengthPType extends EKeyType[Double]('length)
  object WidthPType extends EKeyType[Double]('width)

  "The isotope config" should "load from the classpath" in {

    // declare your extensible model type
    class Container(props: EProperty[_]*) extends Extensible {

      merge(Seq("blue" as ColorPType)) // a default
      merge(props)

      def color: String = 
        properties.get(ColorPType.id).getOrElse(
          throw new Exception("no required property named color"))
      def length: Double = 
        properties.get(LengthPType.id).getOrElse(
          throw new Exception("no required property named length"))
      def width: Double = 
        properties.get(WidthPType.id).getOrElse(
          throw new Exception("no required property named width"))
    }

    // now make an instance of your container with some values
    val container = new Container(
      "red" as ColorPType, 20.0 as LengthPType, 23.3 as WidthPType)
    assert(container.color == "red")
    assert(container.length == 20.0)
    assert(container.width == 23.3)
  }
}
