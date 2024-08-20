plugins {
	java
	id("org.springframework.boot") version "3.3.2"
	id("io.spring.dependency-management") version "1.1.6"
	id("maven-publish")
}

publishing {
	publications {
		create<MavenPublication>("github") {
			groupId = "zooucat"
			artifactId = "catwork"
			version = "1.0.0"

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

allprojects {
	repositories {
		mavenCentral()
	}
}

subprojects {
	apply {
		plugin("java")
		plugin("org.springframework.boot")
		plugin("io.spring.dependency-management")
	}

	group = "catwork"
	version = "0.0.1-SNAPSHOT"
	java.sourceCompatibility = JavaVersion.VERSION_21

	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-web")
		testImplementation("org.springframework.boot:spring-boot-starter-test")
	}

	tasks {
		jar {
			enabled = false
		}
		bootJar {
			enabled = false
		}
		test {
			enabled = false
		}
	}
}

dependencies {
}

tasks {
	jar {
		enabled = true
		archiveClassifier.set("")
	}
	bootJar {
		enabled  = false
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
