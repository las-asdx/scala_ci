import sbt.librarymanagement.Configurations.Test

name := "scala_ci"

version := "0.1"

scalaVersion := "2.12.11"

resolvers += "aliyun" at "https://maven.aliyun.com/repository/public"

//libraryDependencies += "org.scalatest" %% "scalatest-funspec" % "3.2.5" % "test"
//libraryDependencies +=
//libraryDependencies +=

libraryDependencies ++= Seq(
  "redis.clients" % "jedis" % "2.7.1" % Test,

  "com.github.sebruck" %% "scalatest-embedded-redis" % "0.4.0" % Test,
  "org.scalatest" %% "scalatest" % "3.1.0" % Test,
  "org.scalamock" %% "scalamock" % "5.1.0" % Test,
)