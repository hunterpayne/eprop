
package org.eprop

import org.scalatest.FlatSpec
import org.eprop.EKey._
import org.eprop.EKeyJoda._

import org.joda.time._

class JodaTest extends FlatSpec {

  object IdPType extends EKeyType[String]('id)
  object EventTimePType extends EKeyType[DateTime]('eventTime)
  object InstantPType extends EKeyType[Instant]('eventTime2)
  object MutableTimePType extends EKeyType[MutableDateTime]('eventTime3)
  object HalfLifePType extends EKeyType[Seconds]('halfLife)
  object BuildTimePType extends EKeyType[Minutes]('buildTime)
  object WorkHoursPType extends EKeyType[Hours]('workHours)
  object WorkDaysPType extends EKeyType[Days]('workDays)
  object WeeksPType extends EKeyType[Weeks]('weeks)
  object MonthsPType extends EKeyType[Months]('months)
  object AgePType extends EKeyType[Years]('age)

  "The properties" should "handle joda types correctly" in {

    // declare your extensible model type
    class Container(props: EProperty[_]*) extends Extensible {
      merge(props)

      def id: Option[String] = get[String](IdPType)
      def eventTime: Option[DateTime] = get[DateTime](EventTimePType)
      def eventTime2: Option[Instant] = get[Instant](InstantPType)
      def eventTime3: Option[MutableDateTime] = 
        get[MutableDateTime](MutableTimePType)
      def halfLife: Option[Seconds] = get[Seconds](HalfLifePType)
      def buildTime: Option[Minutes] = get[Minutes](BuildTimePType)
      def workHours: Option[Hours] = get[Hours](WorkHoursPType)
      def workDays: Option[Days] = get[Days](WorkDaysPType)
      def weeks: Option[Weeks] = get[Weeks](WeeksPType)
      def months: Option[Months] = get[Months](MonthsPType)
      def age: Option[Years] = get[Years](AgePType)
    }

    // now make an instant of your container with some values
    val container = new Container(
      "0" as IdPType, new DateTime(10000) as EventTimePType, 
      new Instant(1234567) as InstantPType,
      new MutableDateTime(2345678) as MutableTimePType,
      Seconds.seconds(11) as HalfLifePType, 
      Minutes.minutes(12) as BuildTimePType,
      Hours.hours(13) as WorkHoursPType, Days.days(9) as WorkDaysPType,
      Weeks.weeks(8) as WeeksPType, Months.months(7) as MonthsPType,
      Years.years(29) as AgePType)
    assert(container.id == Some("0"))
    assert(container.eventTime == Some(new DateTime(10000)))
    assert(container.eventTime2 == Some(new Instant(1234567)))
    assert(container.eventTime3 == Some(new DateTime(2345678)))
    assert(container.halfLife == Some(Seconds.seconds(11)))
    assert(container.buildTime == Some(Minutes.minutes(12)))
    assert(container.workHours == Some(Hours.hours(13)))
    assert(container.workDays == Some(Days.days(9)))
    assert(container.weeks == Some(Weeks.weeks(8)))
    assert(container.months == Some(Months.months(7)))
    assert(container.age == Some(Years.years(29)))
  }
}
