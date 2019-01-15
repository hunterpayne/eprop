
package org.eprop

import java.util.Date
import org.scalatest.FlatSpec
import org.eprop.EKey._

class EpropTest extends FlatSpec {

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
  object ColorPType extends EKeyType[String]('color)
  object TimePType extends EKeyType[Date]('time)
  //object StartDatePType extends EKeyType[Enumeration]('startDate)

  "The extensible config" should "read standard data types" in {

    // declare your extensible model type
    class Container(props: EProperty[_]*) extends Extensible {

      merge(Seq("blue" as ColorPType)) // a default
      merge(props)

      def valid: Option[Boolean] = get[Boolean](ValidPType)
      def getByte: Option[Byte] = get[Byte](BytePType)
      def getChar: Option[Char] = get[Char](CharPType)
      def getShort: Option[Short] = get[Short](ShortPType)
      def getInt: Option[Int] = get[Int](IntPType)
      def getLong: Option[Long] = get[Long](LongPType)
      def length: Option[Float] = get[Float](LengthPType)
      def width: Option[Double] = get[Double](WidthPType)
      def color: Option[String] = get[String](ColorPType)
      def time: Option[Date] = get[Date](TimePType)
      //def startDate: Enumeration =
        //properties.get(StartDatePType.id).getOrElse(
          //throw new Exception("no required property named startDate"))
    }

    val container = new Container(
      "red" as ColorPType, 20.0f as LengthPType, 23.3 as WidthPType)
    assert(container.color == Some("red"))
    assert(container.length == Some(20.0))
    assert(container.width == Some(23.3))
    assert(container.getInt == None)

    val container2 = new Container(
      true as ValidPType, 0x88 as 'byte, 'c' as CharPType, 
      16323 as 'short, 15 as IntPType, 100l as LongPType,
      new Date(10) as TimePType) //, Mon as StartDatePType)
    assert(container2.color == Some("blue")) // check that defaults work
    assert(container2.valid == Some(true))
    assert(container2.getByte == Some(0x88))
    assert(container2.getChar == Some('c'))
    assert(container2.getShort == Some(16323))
    assert(container2.getInt == Some(15))
    assert(container2.getLong == Some(100))
    assert(container2.time == Some(new Date(10)))
    //assert(container2.startDate == Some(Mon))
  }
}
