package com.volt.app.ui.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.volt.app.VoltApp
import com.volt.app.data.AppRepository
import com.volt.app.data.wrapper.Resource
import com.volt.app.data.model.LoginRequest
import com.volt.app.data.model.LoginResponse
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var appRepository: AppRepository

    init {
        VoltApp.get().component.inject(this)
    }

    fun login(code:String): LiveData<Resource<LoginResponse>> = liveData(Dispatchers.IO){
        val response = appRepository.login(LoginRequest(code))
        emit(response)
    }
}
