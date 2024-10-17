package com.sudoltyler.fetch

import android.app.Application
import com.sudoltyler.fetch.data.AppContainer
import com.sudoltyler.fetch.data.DefaultAppContainer

class FetchApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}