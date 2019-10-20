package com.tomas.zomato.home

import com.tomas.zomato.home.interfaces.MainPresenterInterface
import com.tomas.zomato.home.interfaces.MainViewInterface
import com.tomas.zomato.home.models.City

class MainPresenter(private val view: MainViewInterface) : MainPresenterInterface {

    private val daoHome = DaoHome(this)

    override fun getCities(searchTerm: String) {
        if (searchTerm.isNotEmpty() && searchTerm.length >= 3) {
            daoHome.getCities(searchTerm)
        }
    }

    override fun showCities(list: List<City>) {
        view.showCities(list.onEach { it.fullName = String.format("%s, %s", it.title, it.country_name) })
    }
}