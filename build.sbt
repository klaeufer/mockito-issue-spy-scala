name := "mockito-spy-issue-scala"

version := "0.1.2"

scalaVersion := "2.12.6"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked")

libraryDependencies ++= Seq(
  "org.mockito"   %  "mockito-inline"  % "2.18.3" % Test,
  "com.novocode"  %  "junit-interface" % "0.11"   % Test
)
