plugins {
	java
	id("org.springframework.boot") version "3.3.2"
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
		plugin("org.springframework.boot")
		plugin("io.spring.dependency-management")
	}

	group = "zooucat"
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
	implementation(project(":global"))
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
