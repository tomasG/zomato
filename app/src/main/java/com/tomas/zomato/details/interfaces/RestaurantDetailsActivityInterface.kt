package com.tomas.zomato.details.interfaces

import com.tomas.zomato.home.models.RestaurantDetailsResponse

interface RestaurantDetailsActivityInterface {

    fun showRestaurantDetails(restaurant:RestaurantDetailsResponse)
}