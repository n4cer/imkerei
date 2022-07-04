name := """imkerei"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.13.8"

libraryDependencies ++= Seq(
  jdbc, javaJdbc,
  "org.postgresql" % "postgresql" % "42.3.4",
  guice,
  ehcache,
  javaWs,
  evolutions,
  "org.mindrot" % "jbcrypt" % "0.3m",
  "com.github.kenglxn.qrgen" % "javase" % "2.6.0",
  "com.google.zxing" % "javase" % "3.2.1"
)

resolvers += "jitpack" at "https://jitpack.io"
