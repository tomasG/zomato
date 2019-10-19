package com.tomas.zomato.home

import android.util.Log
import com.tomas.zomato.backend.RetrofitClient
import com.tomas.zomato.home.interfaces.MainPresenterInterface
import com.tomas.zomato.home.models.CitiesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DaoHome(val presenter: MainPresenterInterface) {

    private val api = RetrofitClient.instance
    private val callBackCities = object : Callback<CitiesResponse> {
        override fun onFailure(call: Call<CitiesResponse>, t: Throwable) {
            Log.d("DaoHome","Error")
        }

        override fun onResponse(call: Call<CitiesResponse>, response: Response<CitiesResponse>) {
            if (response.code() == 200 && response.isSuccessful) {
                presenter.showCities(response.body()?.location_suggestions ?: emptyList())
            }
        }
    }

    fun getCities(term: String) = api.getLocations(term).enqueue(callBackCities)

}