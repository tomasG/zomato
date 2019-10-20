package com.tomas.zomato.backend

import com.tomas.zomato.home.models.CitiesResponse
import com.tomas.zomato.home.models.RestaurantDetailsResponse
import com.tomas.zomato.restaturants.models.RestaurantsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val user_key = "3796790e6bd0e6759a481b90832e49c5"

interface ZomatoAPI {

    @Headers("user-key: $user_key")
    @GET("api/v2.1/locations")
    fun getLocations(@Query("query") term: String): Call<CitiesResponse>


    @Headers("user-key: $user_key")
    @GET("api/v2.1/search")
    fun getRestaurants(
        @Query("entity_id") entityId: Int,
        @Query("entity_type") entityType: String = "city",
        @Query("count") count: Int = 100
    ): Call<RestaurantsResponse>

    @Headers("user-key: $user_key")
    @GET("api/v2.1/restaurant")
    fun getRestaurantDetails(
        @Query("res_id") restaurantId: Long
    ): Call<RestaurantDetailsResponse>
}