package com.shift.geokoder.routes

import com.shift.geokoder.models.schema
import com.shift.geokoder.post
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.Route

fun Route.graphql() {
    post<Graphql> { index ->
        val ret = schema.execute(index.query)
        call.respondText(ret, contentType = ContentType.Application.Json)
    }
}