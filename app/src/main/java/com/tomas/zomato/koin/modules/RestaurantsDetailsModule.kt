package com.tomas.zomato.koin.modules

import com.tomas.zomato.details.DaoRestaurantDetails
import com.tomas.zomato.details.RestaurantDetailsPresenter
import com.tomas.zomato.details.interfaces.RestaurantDetailsActivityInterface
import com.tomas.zomato.details.interfaces.RestaurantDetailsPresenterInterface
import org.koin.dsl.module

val restaurantsDetailsModule = module {
    single { (view: RestaurantDetailsActivityInterface) -> RestaurantDetailsPresenter(view) }
    single { (presenter: RestaurantDetailsPresenterInterface) -> DaoRestaurantDetails(presenter) }
}