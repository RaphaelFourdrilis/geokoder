package com.shift.geokoder.models

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
        val id: String,
        val gid: String,
        val layer: String,
        val country_gid: String,
        val macroregion_gid: String,
        val region_gid: String,
        val locality_gid: String,
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
