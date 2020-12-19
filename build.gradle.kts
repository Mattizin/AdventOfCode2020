import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version "1.4.21"
}

group = "me.schubeck"
version = "1.0-SNAPSHOT"

application {
    mainClassName = "me.schubeck.aoc2020.MainKt"
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "15"
}

tasks.withType<Test> {
    useJUnitPlatform()
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.0")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
}