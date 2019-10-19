package com.tomas.zomato.home.views

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_suggested_city.view.*

class SuggestedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val suggestedCity: TextView = view.suggestedText
}