plugins {
    id("java")
    id("com.gradleup.shadow").version("9.3.0")
    id("com.github.gmazzo.buildconfig").version("6.0.7")
}

allprojects {
    group = "ua.nanit"
    version = "1.10.2"
}

subprojects {
    plugins.apply("java")
    plugins.apply("com.gradleup.shadow")

    tasks.compileJava {
        options.encoding = "UTF-8"
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.13.4")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.13.4")

        implementation("org.spongepowered:configurate-yaml:4.2.0")
        implementation("io.netty:netty-all:4.2.9.Final")
        implementation("net.kyori:adventure-text-serializer-plain:4.26.1")
        implementation("net.kyori:adventure-text-serializer-gson:4.26.1")
        implementation("net.kyori:adventure-text-serializer-legacy:4.26.1")
        implementation("net.kyori:adventure-nbt:4.26.1")
        implementation("com.google.code.gson:gson:2.13.2")
    }

    tasks.shadowJar {
        from("LICENSE")
        minimize()

        relocate("io.netty", "ua.nanit.shaded.io.netty")
        relocate("io.leangen", "ua.nanit.shaded.io.leangen")
        relocate("com.google.errorprone", "ua.nanit.shaded.com.google.errorprone")
        relocate("com.google.gson", "ua.nanit.shaded.com.google.gson")
        relocate("com.grack.nanojson", "ua.nanit.shaded.com.grack.nanojson")
        relocate("net.kyori.adventure", "ua.nanit.shaded.net.kyori.adventure")
        relocate("net.kyori.examination", "ua.nanit.shaded.net.kyori.examination")
        relocate("net.kyori.option", "ua.nanit.shaded.net.kyori.option")
        relocate("org.spongepowered.configurate", "ua.nanit.shaded.org.spongepowered.configurate")
        relocate("revxrsal.commands", "ua.nanit.shaded.revxrsal.commands")
        minimize()
    }

    tasks.test {
        useJUnitPlatform()
    }
}



buildConfig {
    className("BuildConfig")
    packageName("ua.nanit.limbo")
    buildConfigField("LIMBO_VERSION", provider { "${project.version}" })
}
