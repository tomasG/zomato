package com.tomas.zomato.home.models

data class CitiesResponse(val location_suggestions: List<City> = emptyList())

data class City(
    val entity_id: Int = 0,
    val title: String = "",
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val country_name:String = "",
    var fullName:String = ""
)
