package com.tomas.zomato.home.models

import com.tomas.zomato.restaturants.models.Location
import com.tomas.zomato.restaturants.models.UserRating

data class RestaurantDetailsResponse(
    val id: Long = 0,
    val name: String = "",
    val location: Location? = null,
    val user_rating: UserRating? = null,
    val phone_numbers: String = "",
    val average_cost_for_two: String = "",
    val currency: String = "$",
    val cuisines: String = "",
    @Transient
    var costPerTwo: String = ""
)