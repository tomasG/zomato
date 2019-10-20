package com.tomas.zomato.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tomas.zomato.R
import com.tomas.zomato.core.DataHolder
import com.tomas.zomato.details.interfaces.RestaurantDetailsActivityInterface
import com.tomas.zomato.home.models.RestaurantDetailsResponse
import kotlinx.android.synthetic.main.activity_restaurant_details.*
import org.koin.core.KoinComponent
import org.koin.core.inject

class RestaurantDetailsActivity : AppCompatActivity(),
    RestaurantDetailsActivityInterface, KoinComponent {

    private val dataHolder by inject<DataHolder>()
    private val presenter = RestaurantDetailsPresenter(view = this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_details)

        presenter.getRestaurantDetails(dataHolder.restaurantId.toLong())
    }

    override fun showRestaurantDetails(restaurant: RestaurantDetailsResponse) {

        restaurantDetailsNameText.text = restaurant.name
        restaurantDetailsAddressText.text = restaurant.location?.address
        restaurantDetailsCuisineText.text = restaurant.cuisines
        restaurantDetailsRatingBar.rating = restaurant.user_rating?.rating ?: 0.0F
        restaurantDetailsRatingText.text = restaurant.user_rating?.aggregate_rating
        restaurantDetailsAverageCostText.text = restaurant.costPerTwo
        restaurantDetailsPhoneCallImage.setOnClickListener {

        }
    }
}
