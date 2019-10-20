package com.tomas.zomato.restaturants.models

data class RestaurantsResponse(
    val results_found: String = "",
    val results_start: String = "",
    val results_shown: String = "",
    val restaurants: List<RestaurantHolder>
)

data class RestaurantHolder(
    val restaurant: Restaurant? = null
)

data class Restaurant(
    val id: String = "",
    val name: String = "",
    val location: Location? = null,
    val user_rating: UserRating? = null
)

data class Location(
    val address:String = "",
    val locality: String = "",
    val city: String = ""
)

data class UserRating(
    val aggregate_rating: String = "",
    val votes: String = "",
    val rating_text: String = "",
    @Transient
    var votesText:String = "",
    @Transient
    var rating: Float = 0.0F
)