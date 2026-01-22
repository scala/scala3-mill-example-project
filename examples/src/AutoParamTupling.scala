import scala.annotation.threadUnsafe

/**
  * Automatic Tupling of Function Params: https://dotty.epfl.ch/docs/reference/other-new-features/auto-parameter-tupling.html
  */
object AutoParamTupling {

  def test: Unit = {

    /**
      * Lazy vals initialization is thread-safe by default. 
      * It can be opt-out to lower overhead implementation with the @threadUnsafe annotation.
      * https://docs.scala-lang.org/scala3/reference/changed-features/lazy-vals-init.html
      */
    @threadUnsafe lazy val xs: List[String] = List("d", "o", "t", "t", "y")

    /**
      * Current behaviour in Scala 2.12.2 :
      * error: missing parameter type
      * Note: The expected type requires a one-argument function accepting a 2-Tuple.
      * Consider a pattern matching anonymous function, `{ case (s, i) =>  ... }`
      */
    xs.zipWithIndex.map((s, i) => println(s"$i: $s"))

  }
}