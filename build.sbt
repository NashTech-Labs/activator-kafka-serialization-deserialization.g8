name := """kafka-serializer-template"""

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "org.apache.kafka" % "kafka_2.11" % "0.10.1.1",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.6",
  "org.twitter4j" % "twitter4j-stream" % "4.0.6",
  "junit" % "junit" % "4.12" % "test",
  "com.typesafe" % "config" % "1.3.1",
  "com.novocode" % "junit-interface" % "0.11" % "test"
)
