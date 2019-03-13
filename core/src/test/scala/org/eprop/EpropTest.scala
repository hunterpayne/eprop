
package org.eprop

import java.util.Date
import org.scalatest.{ FlatSpec, Matchers }
import org.eprop.EKey._

trait EpropFixture {

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
  object TimePType extends EKeyType[Date]('time)
  //object StartDatePType extends EKeyType[Enumeration]('startDate)

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
    def time: Option[Date] = get[Date](TimePType)
    //def startDate: Enumeration =
      //properties.get(StartDatePType.id).getOrElse(
        //throw new Exception("no required property named startDate"))
  }

  val container = new Container(
    "red" as StringPType, 20.0f as LengthPType, 23.3 as WidthPType)

  val container2 = new Container(
    true as ValidPType, 0x88 as 'byte,
    'c' as CharPType, 16323 as 'short, 15 as IntPType, 100l as LongPType,
    new Date(10) as TimePType) //, Mon as StartDatePType)
}

class EpropTest extends FlatSpec with Matchers with EpropFixture {

  "The extensible config" should "read standard data types" in {

    container.str should be(Some("red"))
    container.length should be(Some(20.0))
    container.width should be(Some(23.3))
    container.getInt should be(None)

    container2.str should be(Some("blue")) // check that defaults work
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
