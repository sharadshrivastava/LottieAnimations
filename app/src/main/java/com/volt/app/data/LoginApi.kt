package com.volt.app.data

import com.volt.app.data.model.LoginRequest
import com.volt.app.data.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {

    @POST(LOGIN_PATH)
    suspend fun login(@Body req:LoginRequest): LoginResponse

    companion object {
        const val BASE_URL = "http://floral-cherry-7673.getsandbox.com"
        const val LOGIN_PATH = "/login"
    }
}