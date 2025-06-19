rootProject.name = "TridentGames"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

include(":composeApp")
include(":core:database")
include(":core:network")
include(":core:data")
include(":core:domain")
include(":features:game:data")
include(":features:game:domain")
include(":features:game:presentation")
include(":features:search:data")
include(":features:search:domain")
include(":features:search:presentation")
include(":features:favorite:data")
include(":features:favorite:domain")
include(":features:favorite:presentation")