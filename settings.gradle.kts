rootProject.name = "catwork"

include("catwork-starters")
include("catwork-autoconfigure")
include("catwork-datasource")
include("catwork-logging")


val springBootVersion = "3.3.3"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            library("spring-logging", "org.springframework.boot:spring-boot-starter-logging:${springBootVersion}")
            library("spring-jpa", "org.springframework.boot:spring-boot-starter-jpa:${springBootVersion}")
            library("spring-mybatis", "org.mybatis.spring.boot:mybatis-spring-boot-starter:${springBootVersion}")
            library("spring-autoconfiguration", "org.springframework.boot:spring-boot-autoconfigure:${springBootVersion}")
        }
    }
}