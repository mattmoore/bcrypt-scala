import Dependencies._

ThisBuild / scalaVersion     := "2.13.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "io.mattmoore"
ThisBuild / organizationName := "bcrypt-scala"

lazy val root = (project in file("."))
  .settings(
    name := "io.mattmoore.scala.bcrypt",
    libraryDependencies += "org.mindrot" % "jbcrypt" % "0.4",
    libraryDependencies += scalaTest % Test
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
