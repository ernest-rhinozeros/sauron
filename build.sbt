
name := """play-scala-starter-example"""

version := "1.0-SNAPSHOT"

resolvers += Resolver.sonatypeRepo("snapshots")

scalaVersion := "2.12.2"


lazy val root = (project in file(".")).enablePlugins(PlayScala, BuildInfoPlugin).
  settings(
    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "com.zeiss.meditec.webservice"
  )

buildInfoKeys ++= Seq[BuildInfoKey](
  "EXTRA_INFO" -> sys.env.getOrElse("EXTRA_INFO", "N/A"),
  "BUILD_NUMBER" -> sys.env.getOrElse("BUILD_NUMBER", "N/A"),
  "BUILD_ID" -> sys.env.getOrElse("BUILD_ID", "N/A"),
  "NODE_NAME" -> sys.env.getOrElse("NODE_NAME", "N/A"),
  "GIT_BRANCH" -> sys.env.getOrElse("GIT_BRANCH", "N/A"),
  "GIT_COMMIT" -> sys.env.getOrElse("GIT_COMMIT", "N/A"),
  "BUILD_AT" -> {
    val dtf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    dtf.setTimeZone(java.util.TimeZone.getTimeZone("UTC"))
    dtf.format(new java.util.Date())
  })

resolvers ++= Seq(
  "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
  Resolver.jcenterRepo
)


libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
libraryDependencies += "com.h2database" % "h2" % "1.4.196"
