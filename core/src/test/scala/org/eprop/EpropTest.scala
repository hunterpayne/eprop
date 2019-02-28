
package org.eprop

import java.awt.{ Color, Dimension, Font, Shape, Stroke, BasicStroke, Rectangle }
import java.util.Date
import org.scalatest.{ FlatSpec, Matchers }
import org.eprop.EKey._

class EpropTest extends FlatSpec with Matchers {

  /*
  object WeekDay extends Enumeration {
    type WeekDay = Value
    val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value
  }
  import WeekDay._
   */

  object ValidPType extends EKeyType[Boolean]('valid)
  object BytePType extends EKeyType[Byte]('byte)
  object CharPType extends EKeyType[Char]('char)
  object ShortPType extends EKeyType[Short]('short)
  object IntPType extends EKeyType[Int]('int)
  object LongPType extends EKeyType[Long]('long)
  object LengthPType extends EKeyType[Float]('length)
  object WidthPType extends EKeyType[Double]('width)
  object StringPType extends EKeyType[String]('str)
  object ColorPType extends EKeyType[Color]('color)
  object DimensionPType extends EKeyType[Dimension]('dimension)
  object FontPType extends EKeyType[Font]('font)
  object ShapePType extends EKeyType[Shape]('shape)
  object StrokePType extends EKeyType[Stroke]('stroke)
  object TimePType extends EKeyType[Date]('time)
  //object StartDatePType extends EKeyType[Enumeration]('startDate)

  "The extensible config" should "read standard data types" in {

    // declare your extensible model type
    class Container(props: EProperty[_]*) extends Extensible {

      merge(Seq("blue" as StringPType)) // a default
      merge(props)

      def valid: Option[Boolean] = get[Boolean](ValidPType)
      def getByte: Option[Byte] = get[Byte](BytePType)
      def getChar: Option[Char] = get[Char](CharPType)
      def getShort: Option[Short] = get[Short](ShortPType)
      def getInt: Option[Int] = get[Int](IntPType)
      def getLong: Option[Long] = get[Long](LongPType)
      def length: Option[Float] = get[Float](LengthPType)
      def width: Option[Double] = get[Double](WidthPType)
      def str: Option[String] = get[String](StringPType)
      def color: Option[Color] = get[Color](ColorPType)
      def dimension: Option[Dimension] = get[Dimension](DimensionPType)
      def font: Option[Font] = get[Font](FontPType)
      def shape: Option[Shape] = get[Shape](ShapePType)
      def stroke: Option[Stroke] = get[Stroke](StrokePType)
      def time: Option[Date] = get[Date](TimePType)
      //def startDate: Enumeration =
        //properties.get(StartDatePType.id).getOrElse(
          //throw new Exception("no required property named startDate"))
    }

    val container = new Container(
      "red" as StringPType, 20.0f as LengthPType, 23.3 as WidthPType)
    assert(container.str == Some("red"))
    assert(container.length == Some(20.0))
    assert(container.width == Some(23.3))
    assert(container.getInt == None)

    val rec: Shape = new Rectangle(0, 0, 20, 10)
    val str: Stroke = new BasicStroke(10)

    val container2 = new Container(
      Color.black as ColorPType, 
      new Dimension(10, 20) as DimensionPType,
      new Font("SansSerif", 0, 12) as FontPType, 
      rec as ShapePType, str as StrokePType,
      true as ValidPType, 0x88 as 'byte,
      'c' as CharPType, 16323 as 'short, 15 as IntPType, 100l as LongPType,
      new Date(10) as TimePType) //, Mon as StartDatePType)
    container2.str should be(Some("blue")) // check that defaults work
    container2.color should be(Some(Color.black))
    container2.dimension should be(Some(new Dimension(10, 20)))
    container2.font should be(Some(new Font("SansSerif", 0, 12)))
    container2.shape should be(Some(new Rectangle(0, 0, 20, 10)))
    container2.stroke should be(Some(new BasicStroke(10)))
    container2.valid should be(Some(true))
    container2.getByte should be(Some(0x88))
    container2.getChar should be(Some('c'))
    container2.getShort should be(Some(16323))
    container2.getInt should be(Some(15))
    container2.getLong should be(Some(100))
    container2.time should be(Some(new Date(10)))
    //container2.startDate should be(Some(Mon))
  }
}
