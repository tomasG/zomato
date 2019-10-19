package com.tomas.zomato.home.interfaces

import com.tomas.zomato.home.models.City

interface MainPresenterInterface {

    fun getCities(searchTerm: String)

    fun showCities(list: List<City>)
}