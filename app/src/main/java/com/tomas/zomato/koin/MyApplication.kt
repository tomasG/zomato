package com.tomas.zomato.koin

import android.app.Application
import com.tomas.zomato.koin.modules.coreModule
import com.tomas.zomato.koin.modules.homeModule
import com.tomas.zomato.koin.modules.restaurantsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(listOf(coreModule, homeModule, restaurantsModule))
        }
    }
}