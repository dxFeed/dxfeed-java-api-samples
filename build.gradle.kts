plugins {
    id("java")
}

group = "com.dxfeed"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(
        url = "https://dxfeed.jfrog.io/artifactory/maven-open/"
    )
}

dependencies {
    implementation("com.devexperts.qd:qds:3.330")
}