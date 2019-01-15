
package org.eprop

import shapeless.HMap

import org.joda.time._

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
  implicit val instantElemKeyToValue = new PropMap[EKeyType[Instant], Instant]
  implicit val mutableDateTimeElemKeyToValue = 
    new PropMap[EKeyType[MutableDateTime], MutableDateTime]
  implicit val secondsElemKeyToValue = new PropMap[EKeyType[Seconds], Seconds]
  implicit val minutesElemKeyToValue = new PropMap[EKeyType[Minutes], Minutes]
  implicit val hoursElemKeyToValue = new PropMap[EKeyType[Hours], Hours]
  implicit val daysElemKeyToValue = new PropMap[EKeyType[Days], Days]
  implicit val weeksElemKeyToValue = new PropMap[EKeyType[Weeks], Weeks]
  implicit val monthsElemKeyToValue = new PropMap[EKeyType[Months], Months]
  implicit val yearsElemKeyToValue = new PropMap[EKeyType[Years], Years]

  // implicit type conversions
  implicit val dateTimeConv: EKey[DateTime] =
    new EKey[DateTime] {
      def as(symbol: Symbol, value: DateTime): EProperty[DateTime] =
        EProperty[DateTime](symbol, value)
      def as(symbol: EKeyType[DateTime], value: DateTime): 
          EProperty[DateTime] = 
        EProperty[DateTime](symbol.sym, value)
    }

  implicit val instantConv: EKey[Instant] =
    new EKey[Instant] {
      def as(symbol: Symbol, value: Instant): EProperty[Instant] = 
        EProperty[Instant](symbol, value)
      def as(symbol: EKeyType[Instant], value: Instant): 
          EProperty[Instant] = 
        EProperty[Instant](symbol.sym, value)
    }

  implicit val mutableDateTimeConv: EKey[MutableDateTime] =
    new EKey[MutableDateTime] {
      def as(symbol: Symbol, value: MutableDateTime): 
          EProperty[MutableDateTime] =
        EProperty[MutableDateTime](symbol, value)
      def as(symbol: EKeyType[MutableDateTime], value: MutableDateTime): 
          EProperty[MutableDateTime] = 
        EProperty[MutableDateTime](symbol.sym, value)
    }

  implicit val secondsConv: EKey[Seconds] =
    new EKey[Seconds] {
      def as(symbol: Symbol, value: Seconds): EProperty[Seconds] = 
        EProperty[Seconds](symbol, value)
      def as(symbol: EKeyType[Seconds], value: Seconds): 
          EProperty[Seconds] = 
        EProperty[Seconds](symbol.sym, value)
    }

  implicit val minutesConv: EKey[Minutes] =
    new EKey[Minutes] {
      def as(symbol: Symbol, value: Minutes): EProperty[Minutes] = 
        EProperty[Minutes](symbol, value)
      def as(symbol: EKeyType[Minutes], value: Minutes): 
          EProperty[Minutes] = 
        EProperty[Minutes](symbol.sym, value)
    }

  implicit val hoursConv: EKey[Hours] =
    new EKey[Hours] {
      def as(symbol: Symbol, value: Hours): EProperty[Hours] = 
        EProperty[Hours](symbol, value)
      def as(symbol: EKeyType[Hours], value: Hours): 
          EProperty[Hours] = 
        EProperty[Hours](symbol.sym, value)
    }

  implicit val daysConv: EKey[Days] =
    new EKey[Days] {
      def as(symbol: Symbol, value: Days): EProperty[Days] = 
        EProperty[Days](symbol, value)
      def as(symbol: EKeyType[Days], value: Days): 
          EProperty[Days] = 
        EProperty[Days](symbol.sym, value)
    }

  implicit val weeksConv: EKey[Weeks] =
    new EKey[Weeks] {
      def as(symbol: Symbol, value: Weeks): EProperty[Weeks] = 
        EProperty[Weeks](symbol, value)
      def as(symbol: EKeyType[Weeks], value: Weeks): 
          EProperty[Weeks] = 
        EProperty[Weeks](symbol.sym, value)
    }

  implicit val monthsConv: EKey[Months] =
    new EKey[Months] {
      def as(symbol: Symbol, value: Months): EProperty[Months] = 
        EProperty[Months](symbol, value)
      def as(symbol: EKeyType[Months], value: Months): 
          EProperty[Months] = 
        EProperty[Months](symbol.sym, value)
    }

  implicit val yearsConv: EKey[Years] =
    new EKey[Years] {
      def as(symbol: Symbol, value: Years): EProperty[Years] = 
        EProperty[Years](symbol, value)
      def as(symbol: EKeyType[Years], value: Years): 
          EProperty[Years] = 
        EProperty[Years](symbol.sym, value)
    }

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
          case m: Instant =>
            builder.add[Instant](
              new EKeyType[Instant](k), t.asInstanceOf[EProperty[Instant]])
            true
          case m: MutableDateTime =>
            builder.add[MutableDateTime](
              new EKeyType[MutableDateTime](k), 
              t.asInstanceOf[EProperty[MutableDateTime]])
            true
          case m: Seconds =>
            builder.add[Seconds](
              new EKeyType[Seconds](k), t.asInstanceOf[EProperty[Seconds]])
            true
          case m: Minutes =>
            builder.add[Minutes](
              new EKeyType[Minutes](k), t.asInstanceOf[EProperty[Minutes]])
            true
          case m: Hours =>
            builder.add[Hours](
              new EKeyType[Hours](k), t.asInstanceOf[EProperty[Hours]])
            true
          case m: Days =>
            builder.add[Days](
              new EKeyType[Days](k), t.asInstanceOf[EProperty[Days]])
            true
          case m: Weeks =>
            builder.add[Weeks](
              new EKeyType[Weeks](k), t.asInstanceOf[EProperty[Weeks]])
            true
          case m: Months =>
            builder.add[Months](
              new EKeyType[Months](k), t.asInstanceOf[EProperty[Months]])
            true
          case m: Years =>
            builder.add[Years](
              new EKeyType[Years](k), t.asInstanceOf[EProperty[Years]])
            true

          case p => false
        }
        case _ => assert(false); false
      }
  }

  delegates += JodaExtensible
}
