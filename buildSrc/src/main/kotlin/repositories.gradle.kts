// Add your dependency repositories here
// Example entries have been provided
repositories {
    // Standard maven repository - this one for GeckoLib
    mavenRepo("Geckolib",
        "https://dl.cloudsmith.io/public/geckolib3/geckolib/maven/",
        "com.geckolib")

    // CurseMaven repository, for artifacts posted on CurseForge that
    // DO NOT have an official maven repository.
    // See: https://cursemaven.com
    //mavenRepo("CurseMaven/CurseForge",
    //    "https://cursemaven.com",
    //    "curse.maven")

    // A basic folder, in your root project location
    // Used for pre-compiled jars that don't have an online repository
    //folder("libs")

    // The local maven repository, for locally published artifacts
    mavenLocal()
}


//<editor-fold defaultstate="collapsed" desc="<Boilerplate>">
/**
 * Standard Maven repository
 *
 * @param name The display name of the repository. Only used for logging
 * @param uri The maven repository URL
 * @param groups The artifact group identifiers for the repository
 */
fun RepositoryHandler.mavenRepo(name: String, uri: String, vararg groups: String) {
    exclusiveContent {
        forRepository {
            maven {
                this.name = name
                this.url = uri(uri)
            }
        }
        filter {
            for (group in groups) {
                includeGroup(group)
            }
        }
    }
}

/**
 * Flat-directory repository, acting as a folder in your project root directory for pre-compiled binaries
 *
 * @param folderName The path of the folder to use, relative to the project root. E.G. "libs"
 */
fun RepositoryHandler.folder(folderName: String) {
    flatDir {
        dirs("$projectDir/$folderName")
    }
}

/**
 * {@link https://central.sonatype.com MavenCentral}-based repository,
 * taking the artifact groups as the identifier
 *
 * @param groups The artifact group identifier for each MavenCentral artifact
 */
fun RepositoryHandler.mavenCentral(vararg groups: String) {
    exclusiveContent {
        forRepository {
            mavenCentral()
        }
        filter {
            for (group in groups) {
                includeGroup(group)
            }
        }
    }
}
//</editor-fold>