# Scala Implicit Ordering and Any Type

This example demonstrates a subtle runtime error that can occur when using implicit `Ordering` instances in Scala with generic types, specifically when the type parameter is `Any`.

The `MyClass` uses an implicit `Ordering[T]` in its `myMethod`. While this works correctly for specific types like `Int` and `String`, passing an instance of `MyClass` with `Any` causes a `MatchError` because there's no implicit `Ordering[Any]` available by default.  The compiler will not detect this issue, leading to a runtime failure.

## How to Reproduce

1. Save the provided `bug.scala` file.
2. Compile and run the code using a Scala compiler.
3. Observe the `MatchError` during execution.

## Solution

See `bugSolution.scala` for a solution that addresses this issue using type constraints and a workaround for `Any` type parameters.