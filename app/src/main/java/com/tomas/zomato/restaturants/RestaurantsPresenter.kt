package com.tomas.zomato.restaturants

import com.tomas.zomato.R
import com.tomas.zomato.restaturants.interfaces.RestaurantsActivityInterface
import com.tomas.zomato.restaturants.interfaces.RestaurantsPresentersInterface
import com.tomas.zomato.restaturants.models.Restaurant

class RestaurantsPresenter(
    private val view: RestaurantsActivityInterface,
    private val fetcher: (reference: Int) -> String
) : RestaurantsPresentersInterface {

    private val dao = DaoRestaurants(this)

    override fun searchRestaurantsByLocation(entityId: Int) {
        dao.getRestaurants(entityId)
    }

    override fun showRestaurants(restaurants: List<Restaurant>) {
        view.showRestaurants(formatFields(restaurants))
    }

    private fun formatFields(restaurants: List<Restaurant>): List<Restaurant> {
        restaurants.forEach {
            it.user_rating?.votesText = fetcher(R.string.total_votes).format(it.user_rating?.votes ?: "")
        }
        return restaurants
    }

}