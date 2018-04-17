package value

import expression._


case class Boole(val b: Boolean) extends Literal {
  def &&(other: Boole) = Boole(b && other.b)
  def ||(other: Boole) = Boole(b || other.b)
  def unary_! = Boole(!b)
  override def toString = b.toString
  def canEqual(other: Any) =  other.isInstanceOf[Boole]
  override def equals(other: Any): Boolean = 
    other match {
       case other: Boole => this.canEqual(other) && (other.b == this.b)
       case _ => false
    }
}

//object Boole extends Literal {
//  def apply(bool: Boolean) = new Boole(bool)
//}