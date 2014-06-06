import org.scalatest.FunSuite

class BasicSuite extends FunSuite {
  test("42") {
    assert(Macros.foo === 42)
  }
}