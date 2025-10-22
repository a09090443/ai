import groovy.xml.dom.DOMCategory.attributes

plugins {
    kotlin("jvm") version "2.2.20"
    kotlin("plugin.serialization") version "2.2.20"
    kotlin("plugin.allopen") version "2.2.20"
    id("application")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "tw.zipe"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val langchain4jVersion = "1.7.1"
val kotlinSerializationVersion = "1.9.0"
val commonsCliVersion = "1.10.0"

dependencies {
    implementation(enforcedPlatform("dev.langchain4j:langchain4j-bom:${langchain4jVersion}"))

    implementation("dev.langchain4j:langchain4j")
    implementation("dev.langchain4j:langchain4j-core")
    implementation("dev.langchain4j:langchain4j-ollama")
    implementation("dev.langchain4j:langchain4j-open-ai")
    implementation("dev.langchain4j:langchain4j-mcp")
    implementation("dev.langchain4j:langchain4j-kotlin")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${kotlinSerializationVersion}")
    implementation("commons-cli:commons-cli:${commonsCliVersion}")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

application {
    mainClass.set("tw.zipe.MainKt")
}

tasks.shadowJar {
    manifest {
        attributes["Main-Class"] = "tw.zipe.MainKt"
    }
}

