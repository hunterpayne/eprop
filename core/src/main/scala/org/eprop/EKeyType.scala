
package org.eprop

import java.util.Date
import scala.collection.mutable.Buffer

import shapeless.HMap

/**
  * A lifting trait assigned to types like Int and String so we can
  * generate EProperty instance using syntatic sugar.  
  * e.g. 10 as AtomicNumberProperty
  */
trait EKey[T] {

  def as(symbol: Symbol, value: T): EKey.EProperty[T]
  def as(typ: EKey.EKeyType[T], value: T): EKey.EProperty[T]
}

/**
  * a scope containing all the implicit type conversions necessary to
  * make the as method of the property object which generates the EProperty
  * which can be casted to a tuple suitable to be added to a HMap
  */
object EKey {

  def apply[A](implicit sh: EKey[A]): EKey[A] = sh

  def as[A: EKey](symbol: Symbol, a: A) = EKey[A].as(symbol, a)
  def as[A: EKey](typ: EKeyType[A], a: A) = EKey[A].as(typ, a)

  // type lifting implicit class
  implicit class EKeyOps[A: EKey](a: A) {
    def as(symbol: Symbol): EProperty[A] = EKey[A].as(symbol, a)
    def as(typ: EKeyType[A]): EProperty[A] = EKey[A].as(typ, a)
  }

  /**
    * An extensible key type.  This class represents a extensible key along with
    * the type of its value.  This class is designed to be extended by an
    * object and that singleton should be used as a key to an extensible set
    * of properties to an object that implements org.kletz.eprop.EKey.Extensible
    * @param name -- the name of this extensible property
    */
  class EKeyType[T](name: Symbol) {
    def id: EKeyType[T] = this
    def sym: Symbol = name
    override def toString: String = "EKeyType(" + name + ")"
    override def equals(that: Any): Boolean = that match {
      case k: EKeyType[_] => name == k.sym
      case _ => false
    }
    override def hashCode: Int = name.hashCode
  }

  /**
    * A class that represents a key and value pair
    * @param name -- the symbol underlying the EKeyType of this property
    * @param value -- the value as the type matching this property matching 
    */
  case class EProperty[T](name: Symbol, value: T)

  // declarations and type conversions necessary to store the EKeys into
  // a shapeless.HMap
  class PropMap[K, V]
  implicit val strElemKeyToValue = new PropMap[EKeyType[String], String]
  implicit val opStrElemKeyToValue = 
    new PropMap[EKeyType[Option[String]], Option[String]]
  implicit val booleanElemKeyToValue = new PropMap[EKeyType[Boolean], Boolean]
  implicit val opBooleanElemKeyToValue =
    new PropMap[EKeyType[Option[Boolean]], Option[Boolean]]
  implicit val intElemKeyToValue = new PropMap[EKeyType[Int], Int]
  implicit val opIntElemKeyToValue =
    new PropMap[EKeyType[Option[Int]], Option[Int]]
  implicit val longElemKeyToValue = new PropMap[EKeyType[Long], Long]
  implicit val opLongElemKeyToValue =
    new PropMap[EKeyType[Option[Long]], Option[Long]]
  implicit val floatElemKeyToValue = new PropMap[EKeyType[Float], Float]
  implicit val opFloatElemKeyToValue =
    new PropMap[EKeyType[Option[Float]], Option[Float]]
  implicit val doubleElemKeyToValue = new PropMap[EKeyType[Double], Double]
  implicit val opDoubleElemKeyToValue =
    new PropMap[EKeyType[Option[Double]], Option[Double]]
  implicit val enumElemKeyToValue = 
    new PropMap[EKeyType[Enumeration], Enumeration]
  implicit val opEnumElemKeyToValue =
    new PropMap[EKeyType[Option[Enumeration]], Option[Enumeration]]

  implicit val dateElemKeyToValue = 
    new PropMap[EKeyType[Date], Date]
  implicit val opDateElemKeyToValue =
    new PropMap[EKeyType[Option[Date]], Option[Date]]

  // implicit type conversions
  implicit val enumConv: EKey[Enumeration] =
    new EKey[Enumeration] {
      def as(symbol: Symbol, value: Enumeration) : 
          EProperty[Enumeration] =
        EProperty[Enumeration](symbol, value)
      def as(symbol: EKeyType[Enumeration], value: Enumeration) :
          EProperty[Enumeration] =
        EProperty[Enumeration](symbol.sym, value)
    }

  implicit val opEnumConv: EKey[Option[Enumeration]] =
    new EKey[Option[Enumeration]] {
      def as(symbol: Symbol, value: Option[Enumeration]) : 
          EProperty[Option[Enumeration]] =
        EProperty[Option[Enumeration]](symbol, value)
      def as(symbol: EKeyType[Option[Enumeration]], value: Option[Enumeration]):
          EProperty[Option[Enumeration]] =
        EProperty[Option[Enumeration]](symbol.sym, value)
    }

  implicit val booleanConv: EKey[Boolean] =
    new EKey[Boolean] {
      def as(symbol: Symbol, value: Boolean): EProperty[Boolean] = 
        EProperty[Boolean](symbol, value)
      def as(symbol: EKeyType[Boolean], value: Boolean): EProperty[Boolean] = 
        EProperty[Boolean](symbol.sym, value)
    }

  implicit val opBooleanConv: EKey[Option[Boolean]] =
    new EKey[Option[Boolean]] {
      def as(symbol: Symbol, value: Option[Boolean]): 
          EProperty[Option[Boolean]] =
        EProperty[Option[Boolean]](symbol, value)
      def as(symbol: EKeyType[Option[Boolean]], value: Option[Boolean]): 
          EProperty[Option[Boolean]] =
        EProperty[Option[Boolean]](symbol.sym, value)
    }

  implicit val intConv: EKey[Int] =
    new EKey[Int] {
      def as(symbol: Symbol, value: Int): EProperty[Int] = 
        EProperty[Int](symbol, value)
      def as(symbol: EKeyType[Int], value: Int): EProperty[Int] = 
        EProperty[Int](symbol.sym, value)
    }

  implicit val opIntConv: EKey[Option[Int]] =
    new EKey[Option[Int]] {
      def as(symbol: Symbol, value: Option[Int]): EProperty[Option[Int]] =
        EProperty[Option[Int]](symbol, value)
      def as(symbol: EKeyType[Option[Int]], value: Option[Int]): 
          EProperty[Option[Int]] =
        EProperty[Option[Int]](symbol.sym, value)
    }

  implicit val longConv: EKey[Long] =
    new EKey[Long] {
      def as(symbol: Symbol, value: Long): EProperty[Long] = 
        EProperty[Long](symbol, value)
      def as(symbol: EKeyType[Long], value: Long): EProperty[Long] = 
        EProperty[Long](symbol.sym, value)
    }

  implicit val opLongConv: EKey[Option[Long]] =
    new EKey[Option[Long]] {
      def as(symbol: Symbol, value: Option[Long]): 
          EProperty[Option[Long]] =
        EProperty[Option[Long]](symbol, value)
      def as(symbol: EKeyType[Option[Long]], value: Option[Long]): 
          EProperty[Option[Long]] =
        EProperty[Option[Long]](symbol.sym, value)
    }

  implicit val floatConv: EKey[Float] =
    new EKey[Float] {
      def as(symbol: Symbol, value: Float): EProperty[Float] = 
        EProperty[Float](symbol, value)
      def as(symbol: EKeyType[Float], value: Float): 
          EProperty[Float] = 
        EProperty[Float](symbol.sym, value)
    }

  implicit val opFloatConv: EKey[Option[Float]] =
    new EKey[Option[Float]] {
      def as(symbol: Symbol, value: Option[Float]): 
          EProperty[Option[Float]] =
        EProperty[Option[Float]](symbol, value)
      def as(symbol: EKeyType[Option[Float]], value: Option[Float]): 
          EProperty[Option[Float]] = 
        EProperty[Option[Float]](symbol.sym, value)
    }

  implicit val doubleConv: EKey[Double] =
    new EKey[Double] {
      def as(symbol: Symbol, value: Double): EProperty[Double] = 
        EProperty[Double](symbol, value)
      def as(symbol: EKeyType[Double], value: Double): 
          EProperty[Double] = 
        EProperty[Double](symbol.sym, value)
    }

  implicit val opDoubleConv: EKey[Option[Double]] =
    new EKey[Option[Double]] {
      def as(symbol: Symbol, value: Option[Double]): 
          EProperty[Option[Double]] =
        EProperty[Option[Double]](symbol, value)
      def as(symbol: EKeyType[Option[Double]], value: Option[Double]): 
          EProperty[Option[Double]] = 
        EProperty[Option[Double]](symbol.sym, value)
    }

  implicit val stringConv: EKey[String] =
    new EKey[String] {
      def as(symbol: Symbol, value: String): EProperty[String] = 
        EProperty[String](symbol, value)
      def as(symbol: EKeyType[String], value: String): 
          EProperty[String] =
        EProperty[String](symbol.sym, value)
    }

  implicit val opStringConv: EKey[Option[String]] =
    new EKey[Option[String]] {
      def as(symbol: Symbol, value: Option[String]): 
          EProperty[Option[String]] =
        EProperty[Option[String]](symbol, value)
      def as(symbol: EKeyType[Option[String]], value: Option[String]): 
          EProperty[Option[String]] = 
        EProperty[Option[String]](symbol.sym, value)
    }

  implicit val dateConv: EKey[Date] =
    new EKey[Date] {
      def as(symbol: Symbol, value: Date): EProperty[Date] = 
        EProperty[Date](symbol, value)
      def as(symbol: EKeyType[Date], value: Date): 
          EProperty[Date] =
        EProperty[Date](symbol.sym, value)
    }

  implicit val opDateConv: EKey[Option[Date]] =
    new EKey[Option[Date]] {
      def as(symbol: Symbol, value: Option[Date]): 
          EProperty[Option[Date]] =
        EProperty[Option[Date]](symbol, value)
      def as(symbol: EKeyType[Option[Date]], value: Option[Date]): 
          EProperty[Option[Date]] = 
        EProperty[Option[Date]](symbol.sym, value)
    }

  // case a EProperty to a tuple suitable for storing in a HMap
  implicit def toTuple[T](e: EProperty[T]): (EKeyType[T], T) =
    (new EKeyType[T](e.name), e.value)

  trait HasConv {
    def conv(builder: HMapBuilder, t: Any): Boolean
  }

  class HMapBuilder(m: HMap[PropMap], k: Buffer[EKeyType[_]]) {
    var map: HMap[PropMap] = m
    def keys: Seq[EKeyType[_]] = k.toSeq
    def add[T](key: EKeyType[T], value: EProperty[T])(
      implicit c: PropMap[EKeyType[T], T]): Unit = {
      map = map + value
      k += key
    }
  }

  private[eprop] val delegates: Buffer[HasConv] = Buffer()

  /**
    * trait to extend if you want to use extensible EKeys in a specific class
    */
  trait Extensible {

    protected def conv(builder: HMapBuilder, t: Any): Boolean =
      t match {
        case EProperty(k, v) => v match {
          case s: String =>
            builder.add[String](
              new EKeyType[String](k), t.asInstanceOf[EProperty[String]])
            true
          case Some(s: String) =>
            builder.add[Option[String]](
              new EKeyType[Option[String]](k), 
              t.asInstanceOf[EProperty[Option[String]]])
            true
          case b: Boolean =>
            builder.add[Boolean](
              new EKeyType[Boolean](k), t.asInstanceOf[EProperty[Boolean]])
            true
          case Some(b: Boolean) =>
            builder.add[Option[Boolean]](
              new EKeyType[Option[Boolean]](k), 
              t.asInstanceOf[EProperty[Option[Boolean]]])
            true
          case i: Int =>
            builder.add[Int](
              new EKeyType[Int](k), t.asInstanceOf[EProperty[Int]])
            true
          case Some(i: Int) =>
            builder.add[Option[Int]](
              new EKeyType[Option[Int]](k), 
              t.asInstanceOf[EProperty[Option[Int]]])
            true
          case i: Long =>
            builder.add[Long](
              new EKeyType[Long](k), t.asInstanceOf[EProperty[Long]])
            true
          case Some(i: Long) =>
            builder.add[Option[Long]](
              new EKeyType[Option[Long]](k), 
              t.asInstanceOf[EProperty[Option[Long]]])
            true
          case d: Float =>
            builder.add[Float](
              new EKeyType[Float](k), t.asInstanceOf[EProperty[Float]])
            true
          case Some(d: Float) =>
            builder.add[Option[Float]](
              new EKeyType[Option[Float]](k),
              t.asInstanceOf[EProperty[Option[Float]]])
            true
          case d: Double =>
            builder.add[Double](
              new EKeyType[Double](k), t.asInstanceOf[EProperty[Double]])
            true
          case Some(d: Double) =>
            builder.add[Option[Double]](
              new EKeyType[Option[Double]](k),
              t.asInstanceOf[EProperty[Option[Double]]])
            true
          case e: Enumeration =>
            builder.add[Enumeration](
              new EKeyType[Enumeration](k), 
              t.asInstanceOf[EProperty[Enumeration]])
            true
          case Some(e: Enumeration) =>
            builder.add[Option[Enumeration]](
              new EKeyType[Option[Enumeration]](k), 
              t.asInstanceOf[EProperty[Option[Enumeration]]])
            true
          case d: Date =>
            builder.add[Date](
              new EKeyType[Date](k), t.asInstanceOf[EProperty[Date]])
            true
          case Some(e: Date) =>
            builder.add[Option[Date]](
              new EKeyType[Option[Date]](k), 
              t.asInstanceOf[EProperty[Option[Date]]])
            true
          case None => true // nothing to add
          case p => false
        }
        case _ => assert(false); false
      }

    // the keys
    protected val propsKeys: Buffer[EKeyType[_]] = Buffer()
    // the values stored in a type-safe container
    var properties: HMap[PropMap] = 
      HMap[PropMap](new EKeyType[Int]('dummy) -> 0)

    /** adds new key/value pairs to the extensible propeties of this object */
    def merge(p: Seq[EProperty[_]]): Unit = {

      val builder = new HMapBuilder(properties, propsKeys)
      p.foreach { prop => if (!conv(builder, prop)) {
        if (delegates.forall { del => !del.conv(builder, prop) })
          throw new Exception(s"unable to process property $prop")
      }}

      properties = builder.map
      propKeys = builder.keys
    }

    var propKeys: Seq[EKeyType[_]] = null
  }
}
