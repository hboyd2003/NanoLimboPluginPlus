repositories {
    mavenCentral()
    maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
    maven { url = uri("https://jitpack.io") }
    maven { url = uri("https://libraries.minecraft.net") }
}

dependencies {
    implementation(project(":api", configuration = "shadow"))
    implementation("com.github.Revxrsal.Lamp:common:3.0.8")
    implementation("com.github.Revxrsal.Lamp:bungee:3.0.8")
    compileOnly("net.md-5:bungeecord-api:1.21-R0.4")
}