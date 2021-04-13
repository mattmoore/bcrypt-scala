# BCrypt Scala

Scala type-safe library built on top of JBCrypt.

Add the bintray repository to your build.sbt:

```scala
resolvers += Resolver.bintrayRepo("mattmoore", "bcrypt-scala")
```

Next, import the dependency:

```scala
libraryDependencies += "io.mattmoore" %% "bcrypt-scala" % "0.1.0"
```

Finally, you can import the package into your Scala files:

```scala
import io.mattmoore.bcrypt.BCrypt
```

## Usage

### Hash Passwords

#### With Auto-Generated Salts

```scala
val hashed = BCrypt.hashpw("password")
Right("$2a$10$GgITn8IWUCHRzar0BnjgMODAGSDM.Io26kJga0L5PVU0JQd4AHB96")
```

#### Verify Password

```scala
val hashed = "$2a$10$GgITn8IWUCHRzar0BnjgMODAGSDM.Io26kJga0L5PVU0JQd4AHB96"

BCrypt.checkpw("password", hashed)
Right(true)

BCrypt.checkpw("wrong", hashed)
Left("Invalid password.")
```