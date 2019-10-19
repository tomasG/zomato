package com.tomas.zomato.home.models

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tomas.zomato.R
import com.tomas.zomato.home.interfaces.MainViewInterface
import com.tomas.zomato.home.views.SuggestedViewHolder

class SuggestedAdapter(
    var list: List<City> = emptyList(),
    val view: MainViewInterface? = null
) : RecyclerView.Adapter<SuggestedViewHolder>() {

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestedViewHolder {
        return SuggestedViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_suggested_city, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SuggestedViewHolder, position: Int) {
        holder.suggestedCity.text = list[position].fullName
        holder.itemView.setOnClickListener {
            view?.onCityClicked(list[position])
        }
    }
}