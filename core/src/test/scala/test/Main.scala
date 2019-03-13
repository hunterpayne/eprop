
package test

import java.util.Date

import org.eprop.EpropFixture

object Main extends App with EpropFixture {

  assert(container.str == Some("red"))
  assert(container.length == Some(20.0))
  assert(container.width == Some(23.3))
  assert(container.getInt == None)

  assert(container2.str == Some("blue")) // check that defaults work
  assert(container2.valid == Some(true))
  assert(container2.getByte == Some(0x88))
  assert(container2.getChar == Some('c'))
  assert(container2.getShort == Some(16323))
  assert(container2.getInt == Some(15))
  assert(container2.getLong == Some(100))
  assert(container2.time == Some(new Date(10)))
  //assert(container2.startDate == Some(Mon))  

  println("Eprop Test worked")
}
