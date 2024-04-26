plugins {
    id("java")
}

group = "com.dxfeed"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(files("libs/dxfeed-api-3.327.jar"))
    implementation(files("libs/dxlib-3.327.jar"))
    implementation(files("libs/dxfeed-impl-3.327.jar"))
}