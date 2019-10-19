package com.tomas.zomato.restaturants

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tomas.zomato.R
import com.tomas.zomato.core.DataHolder
import com.tomas.zomato.core.Router
import com.tomas.zomato.restaturants.interfaces.RestaurantsActivityInterface
import com.tomas.zomato.restaturants.models.Restaurant
import com.tomas.zomato.restaturants.models.RestaurantAdapter
import kotlinx.android.synthetic.main.activity_restaurants.*
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.parameter.parametersOf

class RestaurantsActivity : AppCompatActivity(), RestaurantsActivityInterface, KoinComponent {

    private val dataHolder by inject<DataHolder>()
    private val presenter by inject<RestaurantsPresenter> { parametersOf(this) }
    private lateinit var restaurantAdapter: RestaurantAdapter
    private val router by inject<Router>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurants)
        initViews()
        presenter.searchRestaurantsByLocation(dataHolder.entityId)
    }

    private fun initViews() {
        restaurantAdapter = RestaurantAdapter(
            view = this,
            recyclerView = restaurantRecyclerView
        )
        restaurantRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@RestaurantsActivity, RecyclerView.VERTICAL, false)
            adapter = restaurantAdapter
        }

    }

    override fun showRestaurants(restaurants: List<Restaurant>) {
        if (restaurants.isNotEmpty()) {
            with(restaurantAdapter) {
                list = restaurants
                notifyDataSetChanged()
            }
        }
    }

    override fun onRestaurantClicked(restaurant: Restaurant) {
        dataHolder.restaurant = restaurant
        router.
    }
}
