package com.sagarganatra.mvpkotlinmovielist

import android.app.Application
import com.sagarganatra.mvpkotlinmovielist.di.components.ApplicationComponent
import com.sagarganatra.mvpkotlinmovielist.di.components.DaggerApplicationComponent
import com.sagarganatra.mvpkotlinmovielist.di.modules.ApplicationModule
import javax.inject.Inject

class App: Application() {
    @Inject
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }
}