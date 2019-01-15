
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

  object ColorPType extends EKeyType[String]('color)
  object LengthPType extends EKeyType[Float]('length)
  object WidthPType extends EKeyType[Double]('width)
  object ValidPType extends EKeyType[Boolean]('valid)
  object IntPType extends EKeyType[Int]('int)
  object LongPType extends EKeyType[Long]('long)
  object TimePType extends EKeyType[Date]('time)
  //object StartDatePType extends EKeyType[Enumeration]('startDate)

  "The extensible config" should "read standard data types" in {

    // declare your extensible model type
    class Container(props: EProperty[_]*) extends Extensible {

      merge(Seq("blue" as ColorPType)) // a default
      merge(props)

      def color: String = 
        properties.get(ColorPType.id).getOrElse(
          throw new Exception("no required property named color"))
      def length: Float = 
        properties.get(LengthPType.id).getOrElse(
          throw new Exception("no required property named length"))
      def width: Double = 
        properties.get(WidthPType.id).getOrElse(
          throw new Exception("no required property named width"))
      def valid: Boolean = 
        properties.get(ValidPType.id).getOrElse(
          throw new Exception("no required property named valid"))
      def getInt: Int = 
        properties.get(IntPType.id).getOrElse(
          throw new Exception("no required property named int"))
      def getLong: Long = 
        properties.get(LongPType.id).getOrElse(
          throw new Exception("no required property named long"))
      def time: Date =
        properties.get(TimePType.id).getOrElse(
          throw new Exception("no required property named time"))
      //def startDate: Enumeration =
        //properties.get(StartDatePType.id).getOrElse(
          //throw new Exception("no required property named startDate"))
    }

    // now make an instance of your container with some values
    val container = new Container(
      "red" as ColorPType, 20.0f as LengthPType, 23.3 as WidthPType)
    assert(container.color == "red")
    assert(container.length == 20.0)
    assert(container.width == 23.3)

    val container2 = new Container(
      true as ValidPType, 15 as IntPType, 100l as LongPType, 
      new Date(10) as TimePType) //, Mon as StartDatePType)
    assert(container2.color == "blue") // check that defaults work
    assert(container2.valid == true)
    assert(container2.getInt == 15)
    assert(container2.getLong == 100)
    assert(container2.time == new Date(10))
    //assert(container2.startDate == Mon)
  }
}
