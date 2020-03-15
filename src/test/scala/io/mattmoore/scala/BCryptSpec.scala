package io.mattmoore.scala

import org.scalatest._

class BCryptSpec extends FlatSpec with Matchers {
  "hashpw" should "hash the password with a generated salt" in {
    BCrypt.hashpw("hello") shouldEqual Right("hello")
  }
}
