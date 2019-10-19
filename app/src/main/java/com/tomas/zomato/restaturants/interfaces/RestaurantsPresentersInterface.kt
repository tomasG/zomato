package com.tomas.zomato.restaturants.interfaces

import com.tomas.zomato.restaturants.models.Restaurant

interface RestaurantsPresentersInterface {

    fun searchRestaurantsByLocation(entityId: Int)

    fun showRestaurants(restaurants: List<Restaurant>)
}