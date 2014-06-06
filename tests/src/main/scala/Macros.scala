import scala.language.experimental.macros
import scala.reflect.macros.blackbox.Context

object Macros {
  def foo: Int = macro impl
  def impl(c: Context) = {
    import c.universe._
    Literal(Constant(43))
  }
}