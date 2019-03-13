
package org.eprop

import shapeless.HMap

import java.awt.{ Color, Dimension, Font, Shape, Stroke }

/**
  * a scope containing all the implicit type conversions necessary to
  * make the as method of the property object which generates the EProperty
  * which can be casted to a tuple suitable to be added to a HMap
  */
object EKeyAwt {

  import EKey._

  // declarations and type conversions necessary to store the EKeys into
  // a shapeless.HMap
  implicit val colorElemKeyToValue = new PropMap[EKeyType[Color], Color]
  implicit val dimElemKeyToValue = new PropMap[EKeyType[Dimension], Dimension]
  implicit val fontElemKeyToValue = new PropMap[EKeyType[Font], Font]
  implicit val shapeElemKeyToValue = new PropMap[EKeyType[Shape], Shape]
  implicit val strokeElemKeyToValue = new PropMap[EKeyType[Stroke], Stroke]

  // implicit type conversions
  implicit val colorConv: EKey[Color] =
    new EKey[Color] {
      def as(symbol: Symbol, value: Color): EProperty[Color] = 
        EProperty[Color](symbol, value)
      def as(symbol: EKeyType[Color], value: Color): 
          EProperty[Color] =
        EProperty[Color](symbol.sym, value)
    }

  implicit val dimensionConv: EKey[Dimension] =
    new EKey[Dimension] {
      def as(symbol: Symbol, value: Dimension): EProperty[Dimension] = 
        EProperty[Dimension](symbol, value)
      def as(symbol: EKeyType[Dimension], value: Dimension): 
          EProperty[Dimension] =
        EProperty[Dimension](symbol.sym, value)
    }

  implicit val shapeConv: EKey[Shape] =
    new EKey[Shape] {
      def as(symbol: Symbol, value: Shape): EProperty[Shape] = 
        EProperty[Shape](symbol, value)
      def as(symbol: EKeyType[Shape], value: Shape): 
          EProperty[Shape] =
        EProperty[Shape](symbol.sym, value)
    }

  implicit val fontConv: EKey[Font] =
    new EKey[Font] {
      def as(symbol: Symbol, value: Font): EProperty[Font] = 
        EProperty[Font](symbol, value)
      def as(symbol: EKeyType[Font], value: Font): 
          EProperty[Font] =
        EProperty[Font](symbol.sym, value)
    }

  implicit val strokeConv: EKey[Stroke] =
    new EKey[Stroke] {
      def as(symbol: Symbol, value: Stroke): EProperty[Stroke] = 
        EProperty[Stroke](symbol, value)
      def as(symbol: EKeyType[Stroke], value: Stroke): 
          EProperty[Stroke] =
        EProperty[Stroke](symbol.sym, value)
    }

  /**
    * trait to extend if you want to use extensible EKeys in a specific class
    */
  object AwtExtensible extends HasConv {

    def conv(builder: HMapBuilder, t: Any): Boolean =
      t match {
        case EProperty(k, v) => v match {
          case c: Color =>
            builder.add[Color](
              new EKeyType[Color](k), t.asInstanceOf[EProperty[Color]])
            true
          case d: Dimension =>
            builder.add[Dimension](
              new EKeyType[Dimension](k), t.asInstanceOf[EProperty[Dimension]])
            true
          case f: Font =>
            builder.add[Font](
              new EKeyType[Font](k), t.asInstanceOf[EProperty[Font]])
            true
          case s: Shape =>
            builder.add[Shape](
              new EKeyType[Shape](k), t.asInstanceOf[EProperty[Shape]])
            true
          case s: Stroke =>
            builder.add[Stroke](
              new EKeyType[Stroke](k), t.asInstanceOf[EProperty[Stroke]])
            true

          case p => false
        }
        case _ => assert(false); false
      }
  }

  delegates += AwtExtensible
}
