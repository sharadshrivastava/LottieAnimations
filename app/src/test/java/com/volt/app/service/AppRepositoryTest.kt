package com.volt.app.service

import com.volt.app.BaseTest
import com.volt.app.data.model.LoginRequest
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AppRepositoryTest : BaseTest() {

    @Before
    fun setup() {
        super.setUp()
        addDelay(UILOAD_DELAY);
    }

    @Test
    fun testSuccessResponse() {
        setResponse("response.json")
        runBlocking {
            Assert.assertEquals("ok", appRepository.login(LoginRequest()).data?.status)
        }
    }

    //In this way we can test other functionality as well.
}