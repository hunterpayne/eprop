
package org.eprop

import org.scalatest.{ FlatSpec, Matchers }
import org.eprop.EKey._
import org.eprop.EKeyJoda._

import org.joda.time._

trait JodaTestFixture {

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
}

class JodaTest extends FlatSpec with JodaTestFixture with Matchers {

  "The properties" should "handle joda types correctly" in {

    container.id should be(Some("0"))
    container.eventTime should be(Some(new DateTime(10000)))
    container.eventTime2 should be(Some(new Instant(1234567)))
    container.eventTime3 should be(Some(new DateTime(2345678)))
    container.halfLife should be(Some(Seconds.seconds(11)))
    container.buildTime should be(Some(Minutes.minutes(12)))
    container.workHours should be(Some(Hours.hours(13)))
    container.workDays should be(Some(Days.days(9)))
    container.weeks should be(Some(Weeks.weeks(8)))
    container.months should be(Some(Months.months(7)))
    container.age should be(Some(Years.years(29)))
  }
}
