plugins {
    kotlin("jvm") version "1.5.10"
}

repositories {
    gradlePluginPortal()
    mavenLocal()
    mavenCentral()
    maven("https://jitpack.io/")
    maven("https://maven.quiltmc.org/repository/release/")
}

dependencies {
    /* JSON I/O */
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.4")

    implementation("io.github.nickacpt.lightclient:LightClientGradle:1.0-SNAPSHOT")
}