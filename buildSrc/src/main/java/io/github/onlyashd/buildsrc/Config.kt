package io.github.onlyashd.buildsrc

import org.gradle.api.Project
import java.util.Properties

fun Project.getVersion(key: String): String {
    val properties = Properties()
    properties.load(file("${rootDir.absolutePath}/version.properties").inputStream())
    return properties.getProperty(key)
}

fun Project.minSdk(): Int = 30
fun Project.targetSdk(): Int = 36
fun Project.compileSdk(): Int = 36
