import Dependencies._

ThisBuild / scalaVersion     := "3.0.0-M3"
ThisBuild / version          := "0.1.0"
ThisBuild / organization     := "io.mattmoore"
ThisBuild / organizationName := "mattmoore"

lazy val root = (project in file("."))
  .settings(
    name := "bcrypt-scala",
    libraryDependencies ++= Seq(
      jbcrypt,
      scalaTest % Test
    )
  )

licenses += "MIT" -> url("http://opensource.org/licenses/MIT")

bintrayRepository := "bcrypt-scala"

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
