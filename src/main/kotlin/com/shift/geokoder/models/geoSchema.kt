package com.shift.geokoder.models

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.github.pgutkowski.kgraphql.KGraphQL
import com.google.gson.Gson

data class GeoJSONResponse(
        val features: List<GeoJSONFeature>
)

data class GeoJSONFeature(
        val geometry: GeoJSONGeometry,
        val properties: GeoJSONProperty
)

data class GeoJSONGeometry(
        val type: String,
        val coordinates: List<Float>
)

data class GeoJSONProperty(
        val name: String,
        val confidence: Double,
        val country_a: String,
        val region: String,
        val locality: String,
        val label: String
)

data class OsrmResponse(
        val routes: List<OsrmRoute>
)

data class OsrmRoute(
        val distance: Double,
        val duration: Double
)
