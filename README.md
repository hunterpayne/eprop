# Extensible Properties for Scala

This library provides typesafe and extensible properties for Scala projects.
It encourages strong typing and provides jars providing support for various
types of properties.

Currently, a default set of types: Boolean, Byte, Char, Short, Int, Long, 
Float, Double, String and Date are supported by the core jar.  The 
eprop-squants jar adds additional type support for the squants types: Mass, 
Energy, Density, etc.
The eprop-joda jar adds additional type support for the joda types:
DateTime, Instant, MutableDateTime, Seconds, Minutes, Hours, Days, Weeks, 
Months, and Years.

```scala
import org.eprop.EKey._

object ColorPType extends EKeyType[String]('color)
object LengthPType extends EKeyType[Double]('length)
object WidthPType extends EKeyType[Double]('width)

// declare your extensible model type
class Container(/* static properties go here */props: EProperty[_]*) extends Extensible {

  merge(Seq("blue" as ColorPType)) // a default
  merge(props)

  def color: Option[String] = get[String](ColorPType)
  def length: Option[Double] = get[Double](LengthPType)
  def width: Option[Double] = get[Double](WidthPType)
  def width2: Option[String] = get[String](WidthPType) // won't compile as WidthPType's type is Double, not String
}

// now make an instance of your container with some values
val c = new Container("read" as ColorPType, 20.0 as LengthPType, 23.3 as WidthPType)
// ask for a random value
c.get[Float]('other) // won't compile unless c has a Float named 'other
c.color // pre-typed so will always compile and return Option[String]

```
