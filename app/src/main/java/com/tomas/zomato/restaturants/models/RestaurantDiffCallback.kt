package com.tomas.zomato.restaturants.models

import androidx.recyclerview.widget.DiffUtil

class RestaurantDiffCallback(
    val newList: List<Restaurant> = emptyList(),
    val oldList: List<Restaurant> = emptyList()
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id.equals(newList[newItemPosition].id)

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id.equals(newList[newItemPosition].id)
}