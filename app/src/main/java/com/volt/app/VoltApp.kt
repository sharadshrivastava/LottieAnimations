package com.volt.app

import android.app.Application
import com.volt.app.di.AppComponent
import com.volt.app.di.DaggerAppComponent
import com.volt.app.di.ServiceModule

class VoltApp : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        instance = this
        component = DaggerAppComponent.builder().serviceModule(ServiceModule()).build()
    }

    companion object {
        private var instance: VoltApp? = null
        fun get(): VoltApp = instance!!
    }
}