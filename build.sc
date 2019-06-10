import mill._, scalalib._

object root extends SbtModule {
  def millSourcePath = ammonite.ops.pwd
  def scalaVersion = "0.16.0-RC3"
  def publishVersion = "0.1.0"
}
