package com.shift.geokoder.routes

import io.ktor.locations.Location

@Location("/graphql")
data class Graphql(val query: String = "")