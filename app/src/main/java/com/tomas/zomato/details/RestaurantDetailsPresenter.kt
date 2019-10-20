package com.tomas.zomato.details

import com.tomas.zomato.details.interfaces.RestaurantDetailsActivityInterface
import com.tomas.zomato.details.interfaces.RestaurantDetailsPresenterInterface
import com.tomas.zomato.home.models.RestaurantDetailsResponse
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.parameter.parametersOf

class RestaurantDetailsPresenter(private val view: RestaurantDetailsActivityInterface) : RestaurantDetailsPresenterInterface,
    KoinComponent {

    private val dao by inject<DaoRestaurantDetails> { parametersOf(this) }

    override fun getRestaurantDetails(restaurantId: Long) {
        dao.getRestaurantDetails(restaurantId)
    }

    override fun showRestaurantDetails(restaurant: RestaurantDetailsResponse) {
        view.showRestaurantDetails(formatRestaurants(restaurant))
    }

    private fun formatRestaurants(restaurant:RestaurantDetailsResponse):RestaurantDetailsResponse =
        restaurant.apply {
            user_rating?.rating = restaurant.user_rating?.aggregate_rating?.toFloat() ?: 0.0F
            costPerTwo = "${restaurant.currency} ${restaurant.average_cost_for_two}"
        }

}