plugins {
    `java-library`
}

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
    implementation(libs.spring.autoconfiguration)

    api(project(":catwork-datasource"))
}

tasks.register("prepareKotlinBuildScriptModel"){
}
