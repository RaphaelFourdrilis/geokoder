package com.shift.geokoder.routes

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import com.shift.geokoder.models.ErrorResponse
import com.shift.geokoder.models.GeoJSONResponse
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.routing.Route

fun Route.pelias() {
    val basePath = "http://localhost:3100"
    val gson = Gson()

    get<SearchInfo> {
        val path = "$basePath/v1/search"
        val (_, _, result) = path.httpGet(
                listOf("text" to it.text, "size" to 1)
        ).responseString()

        when (result) {
            is Result.Failure ->
                call.respond(
                        HttpStatusCode.BadRequest,
                        ErrorResponse("Error: ${result.error}")
                )
            is Result.Success -> {
                val ret = gson.fromJson(result.value, GeoJSONResponse::class.java)

                call.respond(ret)
            }
        }
    }
}