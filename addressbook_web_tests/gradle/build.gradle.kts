plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("com.codeborne:selenide:6.19.0")
    testImplementation("io.github.bonigarcia: webdrivermanager: 5.3.2")
}

tasks.test {
    useJUnitPlatform()
}