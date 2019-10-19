package com.tomas.zomato.backend

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://developers.zomato.com/"

object RetrofitClient {

    val instance: ZomatoAPI = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ZomatoAPI::class.java)


}