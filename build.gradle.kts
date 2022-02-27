import clmodding.craftLandia

plugins {
    java
    id("io.github.nickacpt.lightcraft.gradle")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

lightcraft {
    craftLandia()
}