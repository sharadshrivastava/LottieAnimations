package com.volt.app

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.volt.app.data.AppRepository
import com.volt.app.di.DaggerTestComponent
import com.volt.app.di.TestModule
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Rule
import org.junit.rules.TestRule
import javax.inject.Inject


abstract class BaseTest {

    @Inject
    lateinit var mockWebServer : MockWebServer

    @Inject
    lateinit var appRepository: AppRepository

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    protected val UILOAD_DELAY = 2000L


    fun setUp() {
        val component = DaggerTestComponent.builder()
                .testModule(TestModule()).build()
        component.inject(this)
    }

    fun addDelay(millis: Long) {
        Thread.sleep(millis)
    }

    fun setResponse(fileName: String) {
        val input = this.javaClass.classLoader?.getResourceAsStream(fileName)
        mockWebServer.enqueue(MockResponse().setResponseCode(200).
            setBody(input?.bufferedReader().use {it!!.readText()}))
    }

    fun setErrorResponse() {
        mockWebServer.enqueue(MockResponse().setResponseCode(400).setBody("{}"))
    }
}
