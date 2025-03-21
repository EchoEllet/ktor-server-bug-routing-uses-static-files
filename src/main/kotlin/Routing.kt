package com.example

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import java.io.File

fun Application.configureRouting() {
    routing {

        val basePath = "/"
        install(IgnoreTrailingSlash)
        staticFiles(basePath, File("./kobweb_site")) {
            enableAutoHeadResponse()
            extensions("html")
            default("404.html")
        }
//        File("./kobweb_site").let { siteRootFile ->
//            siteRootFile.walkBottomUp().filter { it.isFile }.forEach { file ->
//                val relativeFile = file.relativeTo(siteRootFile)
//                val name = relativeFile.name.removeSuffix(".html")
//                val parent = relativeFile.parentFile?.let { "${it.invariantSeparatorsPath}/" } ?: ""
//
//                val path = if (name != "index") "$basePath/$parent$name" else "$basePath/$parent"
//                get(path) { call.respondFile(file) }
//                head(path) { call.respond(HttpStatusCode.OK) }
//            }
//
//            // Anything not found is an error
//            val errorFile = siteRootFile.resolve("404.html")
//            if (errorFile.exists()) {
//                // Catch URLs of the form a/b/c/
//                get("{...}/") { call.respondFile(errorFile) }
//                // Catch URLs of the form a/b/c/slug
//                get("{...}") { call.respondFile(errorFile) }
//            }
//        }
    }
}
