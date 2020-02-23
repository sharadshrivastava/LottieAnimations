package com.volt.app.di

import com.volt.app.data.LoginApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun retrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(LoginApi.BASE_URL)
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()


    @Provides
    @Singleton
    fun tramApi(retrofit: Retrofit): LoginApi = retrofit.create(LoginApi::class.java);

    @Provides
    @Singleton
    fun getClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

}