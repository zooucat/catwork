rootProject.name = "catwork"

include("catwork-starters")
include("catwork-autoconfigure")
include("catwork-datasource")
include("catwork-logging")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            library("spring-autoconfiguration", "org.springframework.boot:spring-boot-autoconfigure:3.3.2")
        }
    }
}