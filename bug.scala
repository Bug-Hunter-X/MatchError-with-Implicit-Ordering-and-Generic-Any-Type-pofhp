```scala
class MyClass[T](val value: T) {
  def myMethod(implicit ev: Ordering[T]): T = value
}

object Main extends App {
  implicit val intOrdering = Ordering.Int
  val myInt = new MyClass(5)
  println(myInt.myMethod) // Works fine

  implicit val stringOrdering = Ordering.String
  val myString = new MyClass("hello")
  println(myString.myMethod) // Works fine

  // This will compile but runtime will throw a MatchError
  // because there is no implicit Ordering[Any]
  val myAny = new MyClass(5)
  println(myAny.myMethod)
}
```