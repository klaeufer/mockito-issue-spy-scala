import org.junit.Test
import org.mockito.Mockito._

trait A[+E] { def m(): E }
class B extends A[Int] {
  def m() = -1
}

class SimpleTest {

  @Test def test: Unit = {
    val s = spy(new B)
    verify(s, never).m()
  }
}
