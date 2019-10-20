package com.tomas.zomato.details

import android.util.Log
import com.tomas.zomato.backend.RetrofitClient
import com.tomas.zomato.details.interfaces.RestaurantDetailsPresenterInterface
import com.tomas.zomato.home.models.RestaurantDetailsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DaoRestaurantDetails(val presenter: RestaurantDetailsPresenterInterface) {

    private val api = RetrofitClient.instance

    private val callBackRestaurantDetails = object : Callback<RestaurantDetailsResponse> {
        override fun onFailure(call: Call<RestaurantDetailsResponse>, t: Throwable) {
            Log.d("DaoRestaurantDetails", "Error")
        }

        override fun onResponse(call: Call<RestaurantDetailsResponse>, response: Response<RestaurantDetailsResponse>) {
            if (response.code() == 200 && response.isSuccessful) {
                presenter.showRestaurantDetails(response.body() ?: RestaurantDetailsResponse())
            }
        }
    }

    fun getRestaurantDetails(restaurantId: Long) {
        api.getRestaurantDetails(restaurantId).enqueue(callBackRestaurantDetails)
    }
}