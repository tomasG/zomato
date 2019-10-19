package com.tomas.zomato.core

import android.content.Context
import android.content.Intent
import com.tomas.zomato.restaturants.RestaurantsActivity

class Router {

    fun openRestaurants(context: Context) {
        context.startActivity(Intent(context, RestaurantsActivity::class.java))
    }

    fun goToDetails(context: Context){
        context.startActivity(Intent(context, RestaurantsActivity::class.java))
    }
}