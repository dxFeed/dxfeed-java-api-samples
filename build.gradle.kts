plugins {
    id("java")
}

group = "com.dxfeed"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(files("libs/dxfeed-api.jar"))
    implementation(files("libs/dxlib.jar"))
    implementation(files("libs/qds.jar"))
}