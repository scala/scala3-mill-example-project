# Example mill project that compiles using Dotty

**NOTE**: Dotty support in mill is experimental. For now, sbt remains the
preferred option, see http://github.com/lampepfl/dotty-example-project for an
example sbt project.

## Usage

This is a normal mill project, you can compile code with `mill root.compile` and run it
with `mill root.run`, `mill -i root.console` will start a Dotty REPL.

### IDE support

Dotty comes built-in with IDE support, unfortunately this support is only
available using sbt and not mill for now, see http://dotty.epfl.ch/docs/usage/ide-support.html

## Using Dotty in an existing project

### build.sc
Any version number that starts with `0.` is automatically recognized as Dotty,
you don't need to set up anything:

```scala
def scalaVersion = "3.0.1-RC1"
```

#### Nightly builds
If the latest release of Dotty is missing a bugfix or feature you need, you may
wish to use a nightly build. Look at the bottom of
https://repo1.maven.org/maven2/ch/epfl/lamp/dotty_0.14/ to find the version
number for the latest nightly build.

## Getting your project to compile with Dotty

When porting an existing project, it's a good idea to start out with the Scala 2
compatibility mode (note that this mode affects typechecking and thus may
prevent some valid Dotty code from compiling) by adding to your `build.sc`:

```scala
def scalacOptions = T {
  if (Dep.isDotty(scalaVersion()))
    Seq("-language:Scala2")
  else
    Seq()
}
```

Using the `Dep.isDotty` method ensures that this option will only be set when
compiling with Dotty.

A tool to port code from Scala 2.x to Dotty is currently in development at
https://github.com/scalacenter/scalafix

If your build contains dependencies that have only been published for Scala 2.x,
you may be able to get them to work on Dotty by replacing:

```scala
ivy"a::b:c"
```

by:

```scala
ivy"a::b:c".withDottyCompat(scalaVersion())
```

## Discuss

Feel free to come chat with us on the
[Dotty gitter](http://gitter.im/lampepfl/dotty)!
