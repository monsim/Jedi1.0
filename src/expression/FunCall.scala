package expression

import context._
import value._
import scala.collection.mutable.ListBuffer

case class FunCall(val operator: Identifier, val operands: List[Expression]) extends Expression{
  def execute(env: Environment): Value = {
     var arguments = ListBuffer[Value]()
     for (i <- operands) {
       arguments += i.execute(env)
     }
     alu.execute(operator, arguments.toList)
  }
}