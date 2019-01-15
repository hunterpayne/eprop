
package org.eprop

import org.scalatest.FlatSpec
import org.eprop.EKey._
import org.eprop.EKeySquants._
import squants._
import squants.mass.{ Grams, Kilograms }
import squants.space.{ SquareMeters }

class SquantsTest extends FlatSpec {

  object MassPType extends EKeyType[Mass]('mass)
  object LengthPType extends EKeyType[Length]('length)
  object AreaPType extends EKeyType[Area]('area)

  "The properties" should "read squants types correctly" in {

    // declare your extensible model type
    class Container(props: EProperty[_]*) extends Extensible {

      merge(Seq(Kilograms(10) as MassPType)) // a default
      merge(props)

      def mass: Option[Mass] = get[Mass](MassPType)
      def length: Option[Length] = get[Length](LengthPType)
      def area: Option[Area] = get[Area](AreaPType)
    }

    // now make an instance of your container with some values
    val container = new Container(
      Grams(10) as MassPType, Meters(10.0) as LengthPType, 
      SquareMeters(15.2) as AreaPType)
    assert(container.mass == Some(Kilograms(0.01)))
    assert(container.length == Some(Meters(10.0)))
    assert(container.area == Some(SquareMeters(15.2)))
  }
}
