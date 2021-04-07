import sbt.librarymanagement.Configurations.Test

name := "scala_ci"

version := "0.1"

scalaVersion := "2.12.11"

resolvers += "aliyun" at "https://maven.aliyun.com/repository/public"


libraryDependencies ++= Seq(
  "net.debasishg" %% "redisclient" % "3.30" % Test,
  "redis.embedded" % "embedded-redis" % "embedded-redis-0.3",

  "io.github.embeddedkafka" %% "embedded-kafka" % "2.5.0" % Test,

  "com.h2database" % "h2" % "1.4.197" % Test,

  "org.scalatest" %% "scalatest" % "3.1.0" % Test,
  "org.scalamock" %% "scalamock" % "5.1.0" % Test,
)