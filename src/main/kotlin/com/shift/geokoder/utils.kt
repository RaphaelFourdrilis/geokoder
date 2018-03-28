package com.shift.geokoder

import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.locations.post
import io.ktor.pipeline.PipelineContext
import io.ktor.request.receive
import io.ktor.routing.Route

inline fun <reified T : Any> Route.post(noinline body: suspend PipelineContext<Unit, ApplicationCall>.(T) -> Unit): Route {
    return post<T> {
        body(call.receive())
    }
}