import org.junit.Test
import org.mockito.Mockito._

class SimpleTest {
  
  @Test def testNongeneric(): Unit = {
    val v = new IntSupplier { def get: Int = 1 }
    val s = spy(v)
    verify(s, never).get // OK
  }

  @Test def testNongenericAbstract(): Unit = {
    val v = new AbstractIntSupplier { def get: Int = 1 }
    val s = spy(v)
    verify(s, never).get // OK
  }

  @Test def testGeneric(): Unit = {
    val v = new Supplier[Int] { def get: Int = 1 }
    val s = spy(v)
    verify(s, never).get // FIXME NPE on Linux but not MacOS
  }

  @Test def testGenericAbstract(): Unit = {
    val v = new AbstractSupplier[Int] { def get: Int = 1 }
    val s = spy(v)
    verify(s, never).get // FIXME NPE on Linux but not MacOS
  }
}

trait IntSupplier {
  def get: Int
}

abstract class AbstractIntSupplier extends IntSupplier

trait Supplier[+T] {
  def get: T
}

abstract class AbstractSupplier[+T] extends Supplier[T]
