package io.mattmoore.scala.bcrypt

import org.scalatest._

class BCryptSpec extends FlatSpec with Matchers {
  "hashpw" should "hash the password with a generated salt" in {
    val salt = "$2a$10$GgITn8IWUCHRzar0BnjgMO"
    val password = "password"
    BCrypt.hashpw(password, salt) shouldEqual Right("$2a$10$GgITn8IWUCHRzar0BnjgMODAGSDM.Io26kJga0L5PVU0JQd4AHB96")
  }
}
