package com.tomas.zomato.restaturants.models

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.tomas.zomato.R
import com.tomas.zomato.restaturants.interfaces.RestaurantsActivityInterface
import com.tomas.zomato.restaturants.views.RestaurantViewHolder


class RestaurantAdapter(
    val view: RestaurantsActivityInterface? = null
) : RecyclerView.Adapter<RestaurantViewHolder>() {

    val list: MutableList<Restaurant> = mutableListOf()

    fun updateList(restaurants: List<Restaurant>) {
        val diffResult = DiffUtil.calculateDiff(RestaurantDiffCallback(restaurants, list))
        list.clear()
        list.addAll(restaurants)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        return RestaurantViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_restaurant, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = list[position]
        holder.restaurantName.text = restaurant.name
        holder.restaurantLocation.text = restaurant.location?.locality
        holder.restaurantRatingText.text = restaurant.user_rating?.aggregate_rating
        holder.restaurantRating.rating = restaurant.user_rating?.aggregate_rating?.toFloat() ?: 0.0F
        holder.restaurantVotes.text = restaurant.user_rating?.votesText
        holder.itemView.setOnClickListener {
            view?.onRestaurantClicked(list[position])
        }
    }

}