name := "mockito-spy-issue-scala"

version := "0.2"

scalaVersion := "2.12.9"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked")

libraryDependencies ++= Seq(
  "org.mockito"   % "mockito-core"    % "2.+" % Test,
  "com.novocode"  % "junit-interface" % "0.+" % Test
)

parallelExecution in Test := false
