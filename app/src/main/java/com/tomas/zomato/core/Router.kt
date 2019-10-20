package com.tomas.zomato.core

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.tomas.zomato.details.RestaurantDetailsActivity
import com.tomas.zomato.restaturants.RestaurantsActivity

class Router {

    fun openRestaurants(context: Context) {
        context.startActivity(Intent(context, RestaurantsActivity::class.java))
    }

    fun goToDetails(context: Context){
        val intent = Intent(context,RestaurantDetailsActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }

    fun navigateToPhoneDialer(context: Context, number: String) {
        context.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse(number)))
    }
}