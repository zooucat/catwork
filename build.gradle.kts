plugins {
	java
	id("maven-publish")
	id("org.springframework.boot") version "3.3.3"
	id("io.spring.dependency-management") version "1.1.6"
}

allprojects {
	repositories {
		mavenCentral()
	}
}

subprojects {
	apply {
		plugin("java")
		plugin("maven-publish")
		plugin("org.springframework.boot")
		plugin("io.spring.dependency-management")
	}

	group = "catwork"
	version = "1.0.0"
	java.sourceCompatibility = JavaVersion.VERSION_21

	tasks {
		withType<JavaCompile> {
			options.encoding = "UTF-8"
		}
		bootJar {
			enabled = false
		}
	}
}

