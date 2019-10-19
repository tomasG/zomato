package com.tomas.zomato.restaturants

import android.util.Log
import com.tomas.zomato.backend.RetrofitClient
import com.tomas.zomato.restaturants.interfaces.RestaurantsPresentersInterface
import com.tomas.zomato.restaturants.models.Restaurant
import com.tomas.zomato.restaturants.models.RestaurantsResponse

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DaoRestaurants(private val presenter: RestaurantsPresentersInterface? = null) {

    private val api = RetrofitClient.instance
    private val callBackRestaurants = object : Callback<RestaurantsResponse> {
        override fun onFailure(call: Call<RestaurantsResponse>, t: Throwable) {
            Log.d("DaoRestaunrants", "Error")
        }

        override fun onResponse(call: Call<RestaurantsResponse>, response: Response<RestaurantsResponse>) {
            if (response.code() == 200 && response.isSuccessful) {
                val restaurants = response.body()?.restaurants?.map { it.restaurant }
                presenter?.showRestaurants((restaurants  ?: emptyList<Restaurant>()) as List<Restaurant>)
            }
        }
    }

    fun getRestaurants(entityId: Int) = api.getRestaurants(entityId = entityId).enqueue(callBackRestaurants)


}