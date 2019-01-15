# Extensible Properties for Scala

This library provides typesafe and extensible properties for Scala projects.
Encourages strong typing and provides jars providing support for various
valid types of properties.  

Currently, a default set of types: Int, Long, Float, Double, String, and 
Enumeration are supported by the core jar.  The eprop-squants jar adds 
additional type support for the squants types: Mass, Energy, Density, etc.


```scala
import org.eprop.EKey._

object ColorPType extends EKeyType[String]('color)

object LengthPType extends EKeyType[Double]('length)

object WidthPType extends EKeyType[Double]('width)

// declare your extensible model type
class Container(/* static properties go here */props: EProperty[_]*) extends Extensible {

  merge(Seq("blue" as ColorPType)) // a default
  merge(props)

  def color: String = 
    properties.get(ColorPType.id).getOrElse(
      throw new Exception("no required property named color"))
  def length: Double = 
    properties.get(LengthPType.id).getOrElse(
      throw new Exception("no required property named length"))
  def width: Double = 
    properties.get(WidthPType.id).getOrElse(
      throw new Exception("no required property named width"))

  // other methods here      
}

// now make an instance of your container with some values
new Container("read" as ColorPType, 20.0 as LengthPType, 23.3 as WidthPType)

```

