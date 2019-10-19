package com.tomas.zomato.home.interfaces

import com.tomas.zomato.home.models.City

interface MainViewInterface {

    fun showCities(citiesList: List<City>)
    fun onCityClicked(city: City)
}