package by.xeno

import scala.tools.nsc.Global
import scala.tools.nsc.plugins.{Plugin => NscPlugin, PluginComponent => NscPluginComponent}

class Plugin(val global: Global) extends NscPlugin {
  val name = "plugin"
  val description = "A sample Scala macro plugin"
  val components = List[NscPluginComponent]()
  global.analyzer.addMacroPlugin(MacroPlugin)

  object MacroPlugin extends global.analyzer.MacroPlugin {
    import global._
    import analyzer._
    import scala.reflect.internal.Mode
    override def pluginsMacroExpand(typer: Typer, expandee: Tree, mode: Mode, pt: Type): Option[Tree] = {
      val expanded = Literal(Constant(42)).setType(typeOf[Int])
      linkExpandeeAndExpanded(expandee, expanded)
      Some(expanded)
    }
  }
}
