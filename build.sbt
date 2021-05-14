name := "scala_ci"

version := "0.1"

scalaVersion := "2.12.11"

resolvers += "aliyun" at "https://maven.aliyun.com/repository/public"

val testStack = Seq(
  "org.scalatest" %% "scalatest" % "3.1.0",
  "org.scalamock" %% "scalamock" % "5.1.0",
).map(_ % Test)

val scalaCache = Seq(
  "com.github.cb372" %% "scalacache-guava" % "0.28.0",
  "com.github.cb372" %% "scalacache-redis" % "0.28.0"
)

val embeddedkafka = Seq(
  "io.github.embeddedkafka" %% "embedded-kafka" % "2.6.0",
)

val h2 = Seq(
  "com.h2database" % "h2" % "1.4.197",
)
val redisClient = Seq(
  "net.debasishg" %% "redisclient" % "3.30",
)

libraryDependencies in ThisBuild ++=
  testStack

lazy val embedded_redis = Project(id = "embedded-redis", base = file("embedded-redis"))
  .enablePlugins(JavaAppPackaging)
  .settings(
    libraryDependencies ++=
      Seq("it.ozimov" % "embedded-redis" % "0.7.1") ++
        redisClient
  )

lazy val scala_cache = Project(id = "scala-cache", base = file("scala-cache"))
  .enablePlugins(JavaAppPackaging)
  .dependsOn(embedded_redis)
  .settings(
    libraryDependencies ++=
      scalaCache
  )

lazy val scala_mock = Project(id = "scala-mock", base = file("scala-mock"))
  .enablePlugins(JavaAppPackaging)
  .dependsOn(embedded_redis)
  .settings(
    libraryDependencies ++=
      h2 ++
        embeddedkafka
  )

lazy val scala_test = Project(id = "scala-test", base = file("scala-test"))
  .enablePlugins(JavaAppPackaging)
  .dependsOn(embedded_redis)
  .settings(
  )