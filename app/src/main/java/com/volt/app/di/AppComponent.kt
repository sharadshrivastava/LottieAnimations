package com.volt.app.di

import com.volt.app.ui.login.LoginViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ServiceModule::class))
interface AppComponent {

    fun inject(vm: LoginViewModel)
}