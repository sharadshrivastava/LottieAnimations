package com.volt.app.service

import com.volt.app.BaseTest
import org.junit.Before

class AccountsRepositoryTest : BaseTest() {

    @Before
    fun setup() {
        super.setUp()
        addDelay(UILOAD_DELAY);
    }

    /*@Test
    fun testErrorResponse() {
        setErrorResponse()
        accountDetailsRepository.getAccountDetails().observeForever { listResource ->
            Assert.assertEquals(Resource.Status.ERROR, listResource?.status)
        }
    }

    @Test
    fun testSuccesssResponse() {
        setResponse("response.json")
        accountDetailsRepository.getAccountDetails().observeForever { listResource ->
            Assert.assertEquals(Resource.Status.SUCCESS, listResource?.status)
        }
    }*/

    /*@Test
    fun testAccounts() {
        val expectedAccounts = 3
        setResponse("response.json")

        runBlocking {
            val actualTransactions = appRepository.login().data?.accounts?.size
            Assert.assertEquals(expectedAccounts, actualTransactions)
        }
    }*/

    /*@Test
    fun testMonths() {
        val expectedMonths = 4
        setResponse("response.json")

        accountDetailsRepository.getAccountDetails().observeForever { listResource ->
            val actualTransactions = listResource?.data?.accounts?.get(0)?.months?.size
            Assert.assertEquals(expectedMonths, actualTransactions)
        }
    }

    @Test
    fun testTotal() {
        setResponse("response.json")
        accountDetailsRepository.getAccountDetails().observeForever { listResource ->
            val month = listResource?.data?.accounts?.get(0)?.months?.get(0)
            val actualTotal = month?.household!! + month.groceries!! + month.food!! + month.transport!!
            Assert.assertEquals(month.total, actualTotal)
        }
    }*/
}