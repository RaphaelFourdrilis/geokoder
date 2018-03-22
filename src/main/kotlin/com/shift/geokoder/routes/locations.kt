package com.shift.geokoder.routes

import io.ktor.locations.Location

@Location("/")
data class Index(val name: String = "World of Kotlin")