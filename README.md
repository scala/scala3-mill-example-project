# Example mill project that compiles using Scala 3

**NOTE**: Scala 3 support in mill is experimental. For now, sbt remains the
preferred option. See https://github.com/scala/scala3-example-project for an
example sbt project.

## Usage

This is a normal mill project. You can compile code with `mill root.compile` and run it
with `mill root.run`, `mill -i root.console` will start a Scala 3 REPL.

### IDE support

Scala 3 comes built-in with IDE support, unfortunately this support is only
available using sbt and not mill for now, see http://dotty.epfl.ch/docs/usage/ide-support.html

## Using Scala 3 in an existing project

### build.sc
Any version number that starts with `3.` is automatically recognized as Scala 3;
you don't need to set up anything:

```scala
def scalaVersion = "3.1.0"
```

#### Nightly builds

If the latest release of Scala 3 is missing a bugfix or feature you need, you may
wish to use a nightly build. Look at the bottom of the list of
[releases](https://repo1.maven.org/maven2/org/scala-lang/scala3-compiler_3/)
to find the version number for the latest nightly build.

## Getting your project to compile with Scala 3

When porting an existing project, it's a good idea to start out with the Scala 2
compatibility mode (note that this mode affects typechecking and thus may
prevent some valid Scala 3 code from compiling) by adding to your `build.sc`:

```scala
def scalacOptions = T {
  if (Dep.isDotty(scalaVersion()))
    Seq("-language:Scala2")
  else
    Seq()
}
```

Using the `Dep.isDotty` method ensures that this option will only be set when
compiling with Scala 3.

A tool to port code from Scala 2.x to Scala 3 is available; see
https://scalacenter.github.io/scala-3-migration-guide/docs/tooling/scala-3-migrate-plugin.html

If your build contains dependencies that have only been published for Scala 2.x,
you may be able to get them to work on Scala 3 by replacing:

```scala
ivy"a::b:c"
```

by:

```scala
ivy"a::b:c".withDottyCompat(scalaVersion())
```
