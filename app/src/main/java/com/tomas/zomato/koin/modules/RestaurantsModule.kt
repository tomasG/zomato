package com.tomas.zomato.koin.modules

import com.tomas.zomato.restaturants.DaoRestaurants
import com.tomas.zomato.restaturants.RestaurantsPresenter
import com.tomas.zomato.restaturants.interfaces.RestaurantsActivityInterface
import com.tomas.zomato.restaturants.interfaces.RestaurantsPresentersInterface
import org.koin.dsl.module

val restaurantsModule = module {
    single { (view: RestaurantsActivityInterface,
                 fetcher: (reference:Int) -> String) -> RestaurantsPresenter(view, fetcher) }
    single { (presenter: RestaurantsPresentersInterface) -> DaoRestaurants(presenter) }
}