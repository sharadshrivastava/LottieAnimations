package com.volt.app.di

import com.volt.app.data.LoginApi
import dagger.Module
import dagger.Provides
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class TestModule {

    @Provides
    @Singleton
    fun mockServer(): MockWebServer = MockWebServer()

    @Provides
    @Singleton
    fun retrofit(mockWebServer: MockWebServer): Retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("").toString())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun accountDetailsApi(retrofit: Retrofit): LoginApi = retrofit.create(LoginApi::class.java)


}