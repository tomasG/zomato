package com.tomas.zomato.koin.modules

import com.tomas.zomato.home.DaoHome
import com.tomas.zomato.home.MainPresenter
import com.tomas.zomato.home.interfaces.MainPresenterInterface
import com.tomas.zomato.home.interfaces.MainViewInterface
import org.koin.dsl.module

object HomeModule {
    val homeModule = module {
        single { (view: MainViewInterface) -> MainPresenter(view) }
        single { (presenter: MainPresenterInterface) -> DaoHome(presenter) }
    }
}