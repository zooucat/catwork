tasks.processResources {
	from("src/main/resources") {
		include("banner.txt")
	}
	duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks.register("prepareKotlinBuildScriptModel"){
}
