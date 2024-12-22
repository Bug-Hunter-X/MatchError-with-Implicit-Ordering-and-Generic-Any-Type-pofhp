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

  // Solution: Provide a default Ordering or handle Any explicitly
  // This solution avoids the problem by explicitly avoiding using Ordering[Any]
  val myAny = new MyClass(5)

  // You can now call myMethod only with valid Ordering available
  // println(myAny.myMethod) //This will not compile

}
```