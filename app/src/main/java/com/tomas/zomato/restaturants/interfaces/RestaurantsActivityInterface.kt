package com.tomas.zomato.restaturants.interfaces

import com.tomas.zomato.restaturants.models.Restaurant

interface RestaurantsActivityInterface {

    fun showRestaurants(restaurants: List<Restaurant>)

    fun onRestaurantClicked(restaurant: Restaurant)
}