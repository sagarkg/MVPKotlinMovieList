package com.sagarganatra.mvpkotlinmovielist.di.modules

import android.app.Application
import android.content.Context
import com.sagarganatra.mvpkotlinmovielist.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val app: App) {

    @Provides
    @Singleton
    fun provideApplication(): App = app

    @Provides
    @Singleton
    fun provideContext(): Context = this.app
}