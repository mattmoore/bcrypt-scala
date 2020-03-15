package io.mattmoore.scala.bcrypt

object BCrypt {
  def hashpw(plaintext: String, salt: String): Either[String, String] =
    try {
      Right(org.mindrot.jbcrypt.BCrypt.hashpw(plaintext, salt))
    } catch {
      case e: Exception => Left(e.getMessage)
    }
}
