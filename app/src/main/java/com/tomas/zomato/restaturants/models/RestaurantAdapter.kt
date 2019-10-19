package com.tomas.zomato.restaturants.models

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tomas.zomato.R
import com.tomas.zomato.restaturants.interfaces.OnLoadMoreListener
import com.tomas.zomato.restaturants.interfaces.RestaurantsActivityInterface
import com.tomas.zomato.restaturants.views.RestaurantViewHolder


const val VIEW_TYPE_ITEM = 0
const val VIEW_TYPE_LOADING = 1

class RestaurantAdapter(
    var list: List<Restaurant> = emptyList(),
    val view: RestaurantsActivityInterface? = null,
    val onLoadMoreListener: OnLoadMoreListener? = null,
    val recyclerView: RecyclerView? = null
) : RecyclerView.Adapter<RestaurantViewHolder>() {

    //NICE TO HAVE LAZY LOADING
    /*
    val linearLayoutManager = recyclerView?.layoutManager as LinearLayoutManager
    var totalItemCount = 0
    var lastVisibleItem = 0
    var isLoading = false
    val visibleThreshold = 5

    init {
        recyclerView?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                totalItemCount = linearLayoutManager.itemCount
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition()
                if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                    onLoadMoreListener?.onLoadMore()
                    isLoading = true

                }
            }
        })
    }
    */

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
        holder.restaurantrating.rating = restaurant.user_rating?.aggregate_rating?.toFloat() ?: 0.0F
        holder.restaurantVotes.text = restaurant.user_rating?.votesText
        holder.itemView.setOnClickListener {
            view?.onRestaurantClicked(list[position])
        }
    }

    //NICE TO HAVE LAZY LOADING
    /*
    override fun getItemViewType(position: Int): Int {
        return if (list[position] == null) {
            VIEW_TYPE_LOADING
        } else {
            VIEW_TYPE_ITEM
        }
    }
    */
}