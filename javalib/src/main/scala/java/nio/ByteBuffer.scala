package java.nio

// Ported from Scala.js
import scala.scalanative.unsafe
object ByteBuffer {
  private final val HashSeed = -547316498 // "java.nio.ByteBuffer".##

  def allocate(capacity: Int): ByteBuffer =
    wrap(new Array[Byte](capacity))

  def allocateDirect(capacity: Int): ByteBuffer = allocate(capacity)

  def wrap(array: Array[Byte], offset: Int, length: Int): ByteBuffer =
    HeapByteBuffer.wrap(array, 0, array.length, offset, length, false)

  def wrap(array: Array[Byte]): ByteBuffer =
    wrap(array, 0, array.length)

    // Extended API

  def wrapPointerByte(array: unsafe.Ptr[Byte], length: Int): ByteBuffer =
    PointerByteBuffer.wrap(array, length)
}

abstract class ByteBuffer private[nio] (
    _capacity: Int,
    override private[nio] val _array: Array[Byte],
    private[nio] val _offset: Int
) extends Buffer(_capacity)
    with Comparable[ByteBuffer] {

  private[nio] type ElementType = Byte
  private[nio] type BufferType = ByteBuffer

  private def genBuffer = GenBuffer[ByteBuffer](this)

  def this(_capacity: Int) = this(_capacity, null: Array[Byte], -1)

  private[nio] var _isBigEndian: Boolean = true

  def slice(): ByteBuffer

  def duplicate(): ByteBuffer

  def asReadOnlyBuffer(): ByteBuffer

  def get(): Byte

  def put(b: Byte): ByteBuffer

  def get(index: Int): Byte

  def put(index: Int, b: Byte): ByteBuffer

  @noinline
  def get(dst: Array[Byte], offset: Int, length: Int): ByteBuffer =
    genBuffer.generic_get(dst, offset, length)

  def get(dst: Array[Byte]): ByteBuffer =
    get(dst, 0, dst.length)

  @noinline
  def put(src: ByteBuffer): ByteBuffer =
    genBuffer.generic_put(src)

  @noinline
  def put(src: Array[Byte], offset: Int, length: Int): ByteBuffer =
    genBuffer.generic_put(src, offset, length)

  final def put(src: Array[Byte]): ByteBuffer =
    put(src, 0, src.length)

  @inline final def hasArray(): Boolean =
    genBuffer.generic_hasArray()

  @inline final def array(): Array[Byte] =
    genBuffer.generic_array()

  @inline final def arrayOffset(): Int =
    genBuffer.generic_offset()

  @inline override def position(newPosition: Int): ByteBuffer = {
    super.position(newPosition)
    this
  }

  @inline override def limit(newLimit: Int): ByteBuffer = {
    super.limit(newLimit)
    this
  }

  @inline override def mark(): ByteBuffer = {
    super.mark()
    this
  }

  @inline override def reset(): ByteBuffer = {
    super.reset()
    this
  }

  @inline override def clear(): ByteBuffer = {
    super.clear()
    this
  }

  @inline override def flip(): ByteBuffer = {
    super.flip()
    this
  }

  @inline override def rewind(): ByteBuffer = {
    super.rewind()
    this
  }

  def compact(): ByteBuffer

  def isDirect(): Boolean

  // toString(): String inherited from Buffer

  @noinline
  override def hashCode(): Int =
    genBuffer.generic_hashCode(ByteBuffer.HashSeed)

  override def equals(that: Any): Boolean = that match {
    case that: ByteBuffer => compareTo(that) == 0
    case _                => false
  }

  @noinline
  def compareTo(that: ByteBuffer): Int =
    genBuffer.generic_compareTo(that)(_.compareTo(_))

  final def order(): ByteOrder =
    if (_isBigEndian) ByteOrder.BIG_ENDIAN
    else ByteOrder.LITTLE_ENDIAN

  final def order(bo: ByteOrder): ByteBuffer = {
    if (bo == null)
      throw new NullPointerException
    _isBigEndian = bo == ByteOrder.BIG_ENDIAN
    this
  }

  def getChar(): Char
  def putChar(value: Char): ByteBuffer
  def getChar(index: Int): Char
  def putChar(index: Int, value: Char): ByteBuffer

  def asCharBuffer(): CharBuffer

  def getShort(): Short
  def putShort(value: Short): ByteBuffer
  def getShort(index: Int): Short
  def putShort(index: Int, value: Short): ByteBuffer

  def asShortBuffer(): ShortBuffer

  def getInt(): Int
  def putInt(value: Int): ByteBuffer
  def getInt(index: Int): Int
  def putInt(index: Int, value: Int): ByteBuffer

  def asIntBuffer(): IntBuffer

  def getLong(): Long
  def putLong(value: Long): ByteBuffer
  def getLong(index: Int): Long
  def putLong(index: Int, value: Long): ByteBuffer

  def asLongBuffer(): LongBuffer

  def getFloat(): Float
  def putFloat(value: Float): ByteBuffer
  def getFloat(index: Int): Float
  def putFloat(index: Int, value: Float): ByteBuffer

  def asFloatBuffer(): FloatBuffer

  def getDouble(): Double
  def putDouble(value: Double): ByteBuffer
  def getDouble(index: Int): Double
  def putDouble(index: Int, value: Double): ByteBuffer

  def asDoubleBuffer(): DoubleBuffer

  // Internal API

  override private[nio] def isBigEndian: Boolean =
    _isBigEndian

  private[nio] def load(index: Int): Byte

  private[nio] def store(index: Int, elem: Byte): Unit

  @inline
  private[nio] def load(
      startIndex: Int,
      dst: Array[Byte],
      offset: Int,
      length: Int
  ): Unit =
    genBuffer.generic_load(startIndex, dst, offset, length)

  @inline
  private[nio] def store(
      startIndex: Int,
      src: Array[Byte],
      offset: Int,
      length: Int
  ): Unit =
    genBuffer.generic_store(startIndex, src, offset, length)
}
