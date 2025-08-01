# Example mill project that compiles using Scala 3

## Usage

This is a normal mill project. You can compile code with `mill examples.compile` and run it
with `mill examples.run`, `mill -i examples.console` will start a Scala 3 REPL.

### IDE support

It's recommended to either use [Metals](https://scalameta.org/metals/) with the
editor of your choice or [the Scala Plugin for
IntelliJ](https://blog.jetbrains.com/scala/).

## Using Scala 3 in an existing project

### build.sc

```scala
def scalaVersion = "3.7.2"
```

### Getting your project to compile with Scala 3

For help with porting an existing Scala 2 project to Scala 3, see the
[Scala 3 migration guide](https://docs.scala-lang.org/scala3/guides/migration/compatibility-intro.html).

## Need help?

https://www.scala-lang.org/community/ has links.
