package com.tomas.zomato.koin.modules

import com.tomas.zomato.core.DataHolder
import com.tomas.zomato.core.Router
import org.koin.dsl.module

val coreModule = module {
    single { DataHolder() }
    single { Router() }
}