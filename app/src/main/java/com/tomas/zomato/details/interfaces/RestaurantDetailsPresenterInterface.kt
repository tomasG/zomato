package com.tomas.zomato.details.interfaces

import com.tomas.zomato.home.models.RestaurantDetailsResponse

interface RestaurantDetailsPresenterInterface{

    fun getRestaurantDetails(restaurantId: Long)

    fun showRestaurantDetails(restaurant:RestaurantDetailsResponse)
}