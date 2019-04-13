package com.sagarganatra.mvpkotlinmovielist.di.components

import android.app.Activity
import android.content.Context
import com.sagarganatra.mvpkotlinmovielist.App
import com.sagarganatra.mvpkotlinmovielist.di.modules.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent{
    fun inject(activity: Activity)

    val context: Context
    val app: App
}