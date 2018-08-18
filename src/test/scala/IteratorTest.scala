import org.junit.Test
import org.mockito.Mockito._

import scala.collection.AbstractIterator

class IteratorTest {

  @Test def testAbstractIteratorPrivate(): Unit = {
    val i0 = new AbstractIterator[Int] {
      private var i = 1

      def hasNext: Boolean = true

      def next(): Int = {
        val result = i; i += 1; result
      }
    }
    val it = spy(i0)
    verify(it, never).next() // FIXME NPE on Linux but not MacOS
  }

  @Test def testAbstractIteratorPrivateThis(): Unit = {
    val i0 = new AbstractIterator[Int] {
      private[this] var i = 1

      def hasNext: Boolean = true

      def next(): Int = {
        val result = i; i += 1; result
      }
    }
    val it = spy(i0)
    verify(it, never).next() // OK
  }

  @Test def testIteratorPrivate(): Unit = {
    val i0 = new Iterator[Int] {
      private var i = 1

      def hasNext: Boolean = true

      def next(): Int = {
        val result = i; i += 1; result
      }
    }
    val it = spy(i0)
    verify(it, never).next() // OK
  }

  @Test def testIteratorPrivateThis(): Unit = {
    val i0 = new Iterator[Int] {
      private[this] var i = 1

      def hasNext: Boolean = true

      def next(): Int = {
        val result = i; i += 1; result
      }
    }
    val it = spy(i0)
    verify(it, never).next() // FIXME NPE on Linux but not MacOS
  }

  // https://github.com/scala/scala/blob/v2.12.6/src/library/scala/collection/Iterator.scala#L156
  @Test def testFromPrivate(): Unit = {
    val it = spy(Iterator.from(1))
    verify(it, never).next()
  }

  // https://github.com/scala/scala/blob/v2.12.6/src/library/scala/collection/Iterator.scala#L131
  @Test def testIteratePrivateThis(): Unit = {
    val it = spy(Iterator.iterate(0)(_ + 1))
    verify(it, never).next()
  }
}
