package io.mattmoore.scala.bcrypt

object BCrypt {
  def hashpw(plaintext: String, salt: String): Either[String, String] =
    try {
      Right(org.mindrot.BCrypt.hashpw(plaintext, salt))
    } catch {
      case e: Exception => Left(e.getMessage)
    }

  def hashpw(plaintext: String, logRounds: Int): Either[String, String] =
    try {
      Right(org.mindrot.BCrypt.hashpw(plaintext, org.mindrot.BCrypt.gensalt(logRounds)))
    } catch {
      case e: Exception => Left(e.getMessage)
    }

  def hashpw(plaintext: String): Either[String, String] =
    try {
      Right(org.mindrot.BCrypt.hashpw(plaintext, org.mindrot.BCrypt.gensalt))
    } catch {
      case e: Exception => Left(e.getMessage)
    }

  def checkpw(plaintext: String, hashed: String): Either[String, Boolean] =
    try {
      val tryPw = org.mindrot.BCrypt.hashpw(plaintext, hashed)
      val hashedBytes = hashed.getBytes("UTF-8")
      val tryBytes = tryPw.getBytes("UTF-8")
      if (hashedBytes.length != tryBytes.length) {
        Left("Password did not match.")
      } else {
        val result = (tryBytes zip hashedBytes) { case (a, b) =>
          b ^ a
        }
        Right(org.mindrot.BCrypt.checkpw(plaintext, hashed))
      }
    } catch {
      case e: Exception => Left(e.getMessage)
    }
}
