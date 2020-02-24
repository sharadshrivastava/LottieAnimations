package com.volt.app.data

import com.volt.app.data.model.LoginRequest
import com.volt.app.data.model.LoginResponse
import com.volt.app.data.wrapper.Resource
import com.volt.app.data.wrapper.ResponseHandler
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepository @Inject constructor() {

    @Inject
    lateinit var loginApi: LoginApi

    //As of now retrofit doesn't support error handling with coroutines so errors need to be handled this way.
    suspend fun login(req:LoginRequest): Resource<LoginResponse> {
        try{
            return ResponseHandler.handleSuccess(loginApi.login(req))
        }catch (e: Exception){
            return ResponseHandler.handleException(e)
        }
    }
}