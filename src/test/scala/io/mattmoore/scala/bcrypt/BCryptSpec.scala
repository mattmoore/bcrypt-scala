package io.mattmoore.scala.bcrypt

import org.scalatest._

class BCryptSpec extends FlatSpec with Matchers {
  val password = "password"
  val salt = "$2a$10$GgITn8IWUCHRzar0BnjgMO"
  val hashed = "$2a$10$GgITn8IWUCHRzar0BnjgMODAGSDM.Io26kJga0L5PVU0JQd4AHB96"

  "hashpw" should "hash the password with a provided salt" in {
    BCrypt.hashpw(password, salt) shouldEqual Right(hashed)
  }

  "hashpw" should "hash the password with an auto-generated salt with specified rounds" in {
    BCrypt.hashpw(password, 12).isRight shouldBe true
  }

  "hashpw" should "hash the password with an auto-generated salt with default rounds" in {
    BCrypt.hashpw(password).isRight shouldBe true
  }

  "checkpw" should "return true if the password is valid" in {
    BCrypt.checkpw(password, hashed) shouldBe Right(true)
  }

  "checkpw" should "return false if the password is invalid" in {
    BCrypt.checkpw("wrong", hashed) shouldBe Right(false)
  }
}
