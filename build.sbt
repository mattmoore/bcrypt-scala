import Dependencies._

ThisBuild / scalaVersion     := "2.13.1"
ThisBuild / version          := "0.1.0"
ThisBuild / organization     := "io.mattmoore"
ThisBuild / organizationName := "bcrypt-scala"

lazy val root = (project in file("."))
  .settings(
    name := "io.mattmoore.scala.bcrypt",
    libraryDependencies += "org.mindrot" % "jbcrypt" % "0.4",
    libraryDependencies += scalaTest % Test
  )

bintrayRepository := "bcrypt-scala"
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
