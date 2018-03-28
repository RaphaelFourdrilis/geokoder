package com.shift.geokoder.models

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.github.pgutkowski.kgraphql.KGraphQL
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class GisResp(
        val numFound: Int,
        val QTime: Int,
        val attributions: String,
        val result: Set<GisResult>
)

data class GisResult(
        val id: Int,
        val lng: Double?,
        val lat: Double?,
        val city: String?,
        val countryCode: String?,
        val geocodingLevel: String?,
        val distance: Double?,
        val adm1name: String?,
        val adm2name: String?,
        val adm3name: String?,
        val adm4name: String?,
        val adm5name: String?,
        val houseNumber: String?,
        val name: String?,
        val streetName: String?,
        val state: String?,
        val formatedFull: String?,
        val formatedPostal: String?,
        val sourceId: String?,
        val streetRef: String?,
        val error: String?,
        val citySubdivision: String?,
        val lat_admin_centre: String?,
        val lng_admin_centre: String?,
        val surface: String?,
        val speedMode: String?,
        val maxSpeed: Int?,
        val maxSpeedBackward: Int?,
        val azimuthStart: String?,
        val azimuthEnd: String?,
        val length: String?,
        val oneWay: String?,
        val lanes: Int?,
        val toll: String?,
        val country: String?,
        val civicNumberSuffix: String?,
        val quarter: String?,
        val district: String?,
        val postTown: String?,
        val dependentLocality: String?,
        val streetType: String?,
        val houseNumberInfo: String?,
        val zipCode: String?,
        val score: Double?
)

val schema = KGraphQL.schema {
    val gson = Gson()
    query("reverse") {
        resolver { lng: Double, lat: Double ->
            val (_, _, result) = "/reversegeocoding/search".httpGet(
                    listOf("lat" to lat, "lng" to lng, "format" to "json")).responseString()

            when (result) {
                is Result.Failure -> null
                is Result.Success ->
                    gson.fromJson(result.value, object : TypeToken<GisResp>() {}.type) as GisResp
            }
        }
    }

    query("geocode") {
        resolver { addr: String ->
            val (_, _, result) = "/geocoding/geocode".httpGet(
                    listOf("address" to addr, "format" to "json")).responseString()

            when (result) {
                is Result.Failure -> null
                is Result.Success ->
                    gson.fromJson(result.value, object : TypeToken<GisResp>() {}.type) as GisResp
            }
        }
    }

    type<GisResp>()
    type<GisResult>()
}