package com.tomas.zomato.restaturants.views

import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_restaurant.view.*
import kotlinx.android.synthetic.main.item_suggested_city.view.*

class RestaurantViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val restaurantName: TextView = view.restaurantName
    val restaurantLocation: TextView = view.restaurantLocation
    val restaurantrating: RatingBar = view.restaurantRating
    val restaurantRatingText: TextView = view.restaurantRatingNumberText
    val restaurantVotes: TextView = view.restaurantVotesText
}