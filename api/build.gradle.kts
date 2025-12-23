plugins {
    id("maven-publish")
}

java {
    withSourcesJar()
    withJavadocJar()
}

tasks.jar {
    enabled = false
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = rootProject.group.toString()
            artifactId = rootProject.name + "-" + project.name
            version = rootProject.version.toString()

            artifact(tasks["javadocJar"])
            artifact(tasks["sourcesJar"])
            from(components["shadow"])
        }
    }

    repositories {
        maven {
            mavenLocal()
        }
    }
}