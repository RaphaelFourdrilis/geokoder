package com.shift.geokoder

import com.shift.geokoder.routes.osrm
import com.shift.geokoder.routes.pelias
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.*
import io.ktor.gson.gson
import io.ktor.locations.Locations
import io.ktor.routing.routing
import java.text.DateFormat

@Suppress("unused")
fun Application.geokoder() {
    install(DefaultHeaders)
    install(CallLogging)
    install(ConditionalHeaders)
    install(PartialContent)
    install(Compression)
    install(CORS)
    install(Locations)
    install(ContentNegotiation) {
        gson {
            setDateFormat(DateFormat.LONG)
            disableHtmlEscaping()
            setPrettyPrinting()
            enableComplexMapKeySerialization()
            serializeSpecialFloatingPointValues()
        }
    }
    routing {
        pelias()
        osrm()
    }
}