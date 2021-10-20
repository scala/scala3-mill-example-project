import mill._, scalalib._

object root extends SbtModule {
  def millSourcePath = ammonite.ops.pwd
  def scalaVersion = "3.1.0"
  def publishVersion = "0.1.0"
}
