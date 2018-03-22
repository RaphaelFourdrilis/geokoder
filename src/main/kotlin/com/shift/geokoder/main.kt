package com.shift.geokoder

import com.shift.geokoder.routes.Index
import com.shift.geokoder.routes.IndexResponse
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CORS
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.gson
import io.ktor.http.HttpStatusCode
import io.ktor.locations.Locations
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.routing.routing

fun Application.geokoder() {
    install(DefaultHeaders)
    install(CallLogging)
    install(CORS)
    install(Locations)
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()

            enableComplexMapKeySerialization()

            serializeSpecialFloatingPointValues()
        }
    }
    routing {
        get<Index> { index ->
            call.respond(HttpStatusCode.OK, IndexResponse("Hello, ${index.name}"))
        }
    }
}