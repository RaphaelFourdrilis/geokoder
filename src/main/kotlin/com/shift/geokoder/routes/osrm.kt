package com.shift.geokoder.routes

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import com.shift.geokoder.models.ErrorResponse
import com.shift.geokoder.models.OsrmResponse
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.routing.Route

fun Route.osrm() {
    val basePath = "http://localhost:5000"
    val gson = Gson()

    get<RouteInfo> {
        val coordinates = "${it.firstLng},${it.firstLat};${it.secondLng},${it.secondLat}"
        val path = "$basePath/route/v1/car/$coordinates"
        val (_, _, result) = path.httpGet().responseString()

        when (result) {
            is Result.Failure ->
                call.respond(
                        HttpStatusCode.BadRequest,
                        ErrorResponse("Error: ${result.error}")
                )
            is Result.Success -> {
                val ret = gson.fromJson(result.value, OsrmResponse::class.java)

                call.respond(ret)
            }
        }
    }
}