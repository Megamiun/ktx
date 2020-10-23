val kotlinVersion: String by rootProject
val ashleyVersion: String by rootProject
val spekVersion: String by rootProject
val assertjVersion: String by rootProject
val junitPlatformVersion: String by rootProject

dependencies {
  "compileOnly"("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
  "compileOnly"("com.badlogicgames.ashley:ashley:$ashleyVersion")

  "testCompile"("org.jetbrains.spek:spek-api:$spekVersion")
  "testCompile"("org.assertj:assertj-core:$assertjVersion")

  "testRuntime"("org.junit.platform:junit-platform-launcher:$junitPlatformVersion")
  "testRuntime"("org.jetbrains.spek:spek-junit-platform-engine:$spekVersion")
}

tasks.withType<Test> {
  testLogging {
    showExceptions = true
    events("FAILED", "SKIPPED")
  }

  useJUnitPlatform {
    includeEngines("spek")
  }
}
