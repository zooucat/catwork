publishing {
    publications {
        create<MavenPublication>("github") {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()

            from(components["java"])
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/zooucat/catwork")

            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_USERNAME")
                password = project.findProperty("gpr.token") as String? ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-autoconfigure:3.3.2")
}

tasks.register("prepareKotlinBuildScriptModel"){
}
