package io.mattmoore.scala

object BCrypt {
  def hashpw(plaintext: String): Either[Exception, String] =
    Right(plaintext)
}
