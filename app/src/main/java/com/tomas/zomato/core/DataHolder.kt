package com.tomas.zomato.core

import com.tomas.zomato.home.models.City
import com.tomas.zomato.restaturants.models.Restaurant

class DataHolder(
    var city: City = City(),
    var restaurant: Restaurant = Restaurant()
){
    val entityId:Int = city.entity_id
}