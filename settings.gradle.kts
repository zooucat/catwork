rootProject.name = "catwork"

include("catwork-starters")
include("catwork-autoconfigure")
include("catwork-datasource")
include("catwork-logging")


val springBootVersion = "3.3.2"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            library("spring-jpa", "org.springframework.boot:spring-boot-starter-jpa:${springBootVersion}")
            library("spring-autoconfiguration", "org.springframework.boot:spring-boot-autoconfigure:${springBootVersion}")
        }
    }
}