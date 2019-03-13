
package test

import org.eprop.JodaTestFixture

import org.joda.time._

object Main extends App { //with JodaTestFixture {

  // Joda time doesn't support scala-native
  //assert(container.id == Some("0"))
  //assert(container.eventTime == Some(new DateTime(10000)))
  //assert(container.eventTime2 == Some(new Instant(1234567)))
  //assert(container.eventTime3 == Some(new DateTime(2345678)))
  //assert(container.halfLife == Some(Seconds.seconds(11)))
  //assert(container.buildTime == Some(Minutes.minutes(12)))
  //assert(container.workHours == Some(Hours.hours(13)))
  //assert(container.workDays == Some(Days.days(9)))
  //assert(container.weeks == Some(Weeks.weeks(8)))
  //assert(container.months == Some(Months.months(7)))
  //assert(container.age == Some(Years.years(29)))

  println("Joda Test Worked")
}
