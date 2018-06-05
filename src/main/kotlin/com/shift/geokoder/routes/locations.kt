package com.shift.geokoder.routes

import io.ktor.locations.Location

@Location("/route")
data class RouteInfo(
        val firstLng: String,
        val firstLat: String,
        val secondLng: String,
        val secondLat: String
)

@Location("/search")
data class SearchInfo(
        val text: String
)