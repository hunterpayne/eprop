
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

      def id: String = 
        properties.get(IdPType.id).getOrElse(
          throw new Exception("no required property named id"))
      def eventTime: DateTime = 
        properties.get(EventTimePType.id).getOrElse(
          throw new Exception("no required property named eventTime"))
      def eventTime2: Instant = 
        properties.get(InstantPType.id).getOrElse(
          throw new Exception("no required property named eventTime2"))
      def eventTime3: MutableDateTime = 
        properties.get(MutableTimePType.id).getOrElse(
          throw new Exception("no required property named eventTime3"))
      def halfLife: Seconds = 
        properties.get(HalfLifePType.id).getOrElse(
          throw new Exception("no required property named halfLife"))
      def buildTime: Minutes = 
        properties.get(BuildTimePType.id).getOrElse(
          throw new Exception("no required property named buildTime"))
      def workHours: Hours = 
        properties.get(WorkHoursPType.id).getOrElse(
          throw new Exception("no required property named workHours"))
      def workDays: Days = 
        properties.get(WorkDaysPType.id).getOrElse(
          throw new Exception("no required property named workDays"))
      def weeks: Weeks = 
        properties.get(WeeksPType.id).getOrElse(
          throw new Exception("no required property named weeks"))
      def months: Months = 
        properties.get(MonthsPType.id).getOrElse(
          throw new Exception("no required property named months"))
      def age: Years = 
        properties.get(AgePType.id).getOrElse(
          throw new Exception("no required property named age"))
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
    assert(container.id == "0")
    assert(container.eventTime == new DateTime(10000))
    assert(container.eventTime2 == new Instant(1234567))
    assert(container.eventTime3 == new DateTime(2345678))
    assert(container.halfLife == Seconds.seconds(11))
    assert(container.buildTime == Minutes.minutes(12))
    assert(container.workHours == Hours.hours(13))
    assert(container.workDays == Days.days(9))
    assert(container.weeks == Weeks.weeks(8))
    assert(container.months == Months.months(7))
    assert(container.age == Years.years(29))
  }
}
