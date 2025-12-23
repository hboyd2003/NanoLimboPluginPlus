repositories {
    maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
    maven { url = uri("https://jitpack.io") }
    maven { url = uri("https://repo.papermc.io/repository/maven-public/") }
}

dependencies {
    implementation(project(":api", configuration = "shadow"))
    implementation("com.github.Revxrsal.Lamp:common:3.0.8")
    implementation("com.github.Revxrsal.Lamp:velocity:3.0.8")
    implementation("net.kyori:adventure-text-minimessage:4.11.0")
    compileOnly("com.velocitypowered:velocity-api:3.4.0-SNAPSHOT")
    annotationProcessor("com.velocitypowered:velocity-api:3.4.0-SNAPSHOT")
}