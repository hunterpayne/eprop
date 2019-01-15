
package org.eprop

import shapeless.HMap

import org.joda.time.DateTime

/**
  * a scope containing all the implicit type conversions necessary to
  * make the as method of the property object which generates the EProperty
  * which can be casted to a tuple suitable to be added to a HMap
  */
object EKeyJoda {

  import EKey._

  // declarations and type conversions necessary to store the EKeys into
  // a shapeless.HMap
  implicit val dateTimeElemKeyToValue = 
    new PropMap[EKeyType[DateTime], DateTime]
  implicit val opDateTimeElemKeyToValue =
    new PropMap[EKeyType[Option[DateTime]], Option[DateTime]]

  /*
  implicit val tempElemKeyToValue = 
    new PropMap[EKeyType[Temperature], Temperature]
  implicit val opTempElemKeyToValue =
    new PropMap[EKeyType[Option[Temperature]], Option[Temperature]]
  implicit val thermalCapacityElemKeyToValue = 
    new PropMap[EKeyType[ThermalCapacity], ThermalCapacity]
  implicit val opThermalCapacityElemKeyToValue =
    new PropMap[EKeyType[Option[ThermalCapacity]], Option[ThermalCapacity]]

  implicit val timeElemKeyToValue = new PropMap[EKeyType[Time], Time]
  implicit val opTimeElemKeyToValue =
    new PropMap[EKeyType[Option[Time]], Option[Time]]
  implicit val frequencyElemKeyToValue = 
    new PropMap[EKeyType[Frequency], Frequency]
  implicit val opFrequencyElemKeyToValue =
    new PropMap[EKeyType[Option[Frequency]], Option[Frequency]]
  implicit val timeSquaredElemKeyToValue = 
    new PropMap[EKeyType[TimeSquared], TimeSquared]
  implicit val opTimeSquaredElemKeyToValue =
    new PropMap[EKeyType[Option[TimeSquared]], Option[TimeSquared]]
*/

  // implicit type conversions
  implicit val dateTimeConv: EKey[DateTime] =
    new EKey[DateTime] {
      def as(symbol: Symbol, value: DateTime): EProperty[DateTime] =
        EProperty[DateTime](symbol, value)
      def as(symbol: EKeyType[DateTime], value: DateTime): 
          EProperty[DateTime] = 
        EProperty[DateTime](symbol.sym, value)
    }

  implicit val opDateTimeConv: EKey[Option[DateTime]] =
    new EKey[Option[DateTime]] {
      def as(symbol: Symbol, value: Option[DateTime]): 
          EProperty[Option[DateTime]] =
        EProperty[Option[DateTime]](symbol, value)
      def as(
        symbol: EKeyType[Option[DateTime]], value: Option[DateTime]):
          EProperty[Option[DateTime]] = 
        EProperty[Option[DateTime]](symbol.sym, value)
    }

  /*
  implicit val massConv: EKey[Mass] =
    new EKey[Mass] {
      def as(symbol: Symbol, value: Mass): EProperty[Mass] = 
        EProperty[Mass](symbol, value)
      def as(symbol: EKeyType[Mass], value: Mass): 
          EProperty[Mass] = 
        EProperty[Mass](symbol.sym, value)
    }

  implicit val opMassConv: EKey[Option[Mass]] =
    new EKey[Option[Mass]] {
      def as(symbol: Symbol, value: Option[Mass]): 
          EProperty[Option[Mass]] =
        EProperty[Option[Mass]](symbol, value)
      def as(symbol: EKeyType[Option[Mass]], value: Option[Mass]): 
          EProperty[Option[Mass]] = 
        EProperty[Option[Mass]](symbol.sym, value)
    }
   */

  /**
    * trait to extend if you want to use extensible EKeys in a specific class
    */
  object JodaExtensible extends HasConv {

    def conv(builder: HMapBuilder, t: Any): Boolean =
      t match {
        case EProperty(k, v) => v match {

          case m: DateTime =>
            builder.add[DateTime](
              new EKeyType[DateTime](k), t.asInstanceOf[EProperty[DateTime]])
            true
          case Some(m: DateTime) =>
            builder.add[Option[DateTime]](
              new EKeyType[Option[DateTime]](k), 
              t.asInstanceOf[EProperty[Option[DateTime]]])
            true

            /*
          case m: Jerk =>
            builder.add[Jerk](
              new EKeyType[Jerk](k), t.asInstanceOf[EProperty[Jerk]])
            true
          case Some(m: Jerk) =>
            builder.add[Option[Jerk]](
              new EKeyType[Option[Jerk]](k), 
              t.asInstanceOf[EProperty[Option[Jerk]]])
            true
          case m: MassFlow =>
            builder.add[MassFlow](
              new EKeyType[MassFlow](k), t.asInstanceOf[EProperty[MassFlow]])
            true
          case Some(m: MassFlow) =>
            builder.add[Option[MassFlow]](
              new EKeyType[Option[MassFlow]](k), 
              t.asInstanceOf[EProperty[Option[MassFlow]]])
             true
             */
          case p => false
        }
        case _ => assert(false); false
      }
  }

  delegates += JodaExtensible
}
