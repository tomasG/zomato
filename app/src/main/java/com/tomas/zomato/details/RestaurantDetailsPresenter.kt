package com.tomas.zomato.details

import com.tomas.zomato.details.interfaces.RestaurantDetailsPresenterInterface
import com.tomas.zomato.home.models.RestaurantDetailsResponse

class RestaurantDetailsPresenter(private val view: RestaurantDetailsActivity) : RestaurantDetailsPresenterInterface {

    private val dao = DaoRestaurantDetails(this)

    override fun getRestaurantDetails(restaurantId: Long) {
        dao.getRestaurantDetails(restaurantId)
    }

    override fun showRestaurantDetails(restaurant: RestaurantDetailsResponse) {
        view.showRestaurantDetails(formatRestaurants(restaurant))
    }

    private fun formatRestaurants(restaurant: RestaurantDetailsResponse): RestaurantDetailsResponse =
        restaurant.apply {
            user_rating?.rating = restaurant.user_rating?.aggregate_rating?.toFloat() ?: 0.0F
            costPerTwo = "${restaurant.currency} ${restaurant.average_cost_for_two}"
        }

}