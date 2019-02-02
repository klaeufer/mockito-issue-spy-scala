import org.junit.Test
import org.mockito.Mockito._

trait T { def m(): Int }
class U extends T { def m() = -1 }
abstract class V extends T
class W extends V { def m() = -1 }

trait G[+E] { def m(): E }
class H extends G[Int] { def m() = -1 }
class J extends G[Int] { def m() = (() => -1)() }
abstract class K[+E] extends G[E]
class L extends K[Int] { def m() = -1 }
class M extends K[Int] { def m() = (() => -1)() }

class C[+E](v: E) { def m(): E = v }

class ComprehensiveTest {

  def doTestT(sut: T): Unit = {
    val s = spy(sut)
    verify(s, never).m()
  }

  @Test def testU() = doTestT(new U) // nongeneric + trait => pass
  @Test def testW() = doTestT(new W) // nongeneric + abstract class => pass

  def doTestG(sut: G[Int]): Unit = {
    val s = spy(sut)
    verify(s, never).m()
  }

  @Test def testH() = doTestG(new H) // generic + trait => NPE
  @Test def testJ() = doTestG(new J) // generic + trait + thunk => pass
  @Test def testL() = doTestG(new L) // generic + abstract class => NPE
  @Test def testM() = doTestG(new M) // generic + abstract class + thunk => pass

  @Test def testC(): Unit = {
    val s = spy(new C(-1)) // generic w/o extends => pass
    verify(s, never).m()
  }
}
