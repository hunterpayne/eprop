
package org.eprop

import org.scalatest.FlatSpec
import org.eprop.EKey._
import org.eprop.EKeyJoda._

import org.joda.time.{ DateTime, Years }

class JodaTest extends FlatSpec {

  object IdPType extends EKeyType[String]('id)
  object EventTimePType extends EKeyType[DateTime]('eventTime)
  object AgePType extends EKeyType[Years]('age)

  "The properties" should "handle joda types correctly" in {

    // declare your extensible model type
    class Container(props: EProperty[_]*) extends Extensible {
      merge(props)

      def id: String = 
        properties.get(IdPType.id).getOrElse(
          throw new Exception("no required property named id"))
      def eventTime: DateTime = 
        properties.get(EventTimePType.id).getOrElse(
          throw new Exception("no required property named eventTime"))
      def age: Years = 
        properties.get(AgePType.id).getOrElse(
          throw new Exception("no required property named age"))
    }

    // now make an instance of your container with some values
    val container = new Container(
      "0" as IdPType, new DateTime(10000) as EventTimePType, 
      Years.years(29) as AgePType)
    assert(container.id == "0")
    assert(container.eventTime == new DateTime(10000))
    assert(container.age == Years.years(29))
  }
}
