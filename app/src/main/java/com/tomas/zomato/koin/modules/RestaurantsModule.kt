package com.tomas.zomato.koin.modules

import com.tomas.zomato.home.DaoHome
import com.tomas.zomato.home.MainPresenter
import com.tomas.zomato.home.interfaces.MainPresenterInterface
import com.tomas.zomato.home.interfaces.MainViewInterface
import com.tomas.zomato.restaturants.DaoRestaurants
import com.tomas.zomato.restaturants.RestaurantsPresenter
import com.tomas.zomato.restaturants.interfaces.RestaurantsActivityInterface
import com.tomas.zomato.restaturants.interfaces.RestaurantsPresentersInterface
import org.koin.dsl.module

val restaurantsModule = module {
    single { (view: RestaurantsActivityInterface) -> RestaurantsPresenter(view) }
    single { (presenter: RestaurantsPresentersInterface) -> DaoRestaurants(presenter) }
}