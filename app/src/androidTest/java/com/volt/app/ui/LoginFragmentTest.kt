package com.volt.app.ui


import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.volt.app.R
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * This class is for Android UI testing using Espresso.
 */

@RunWith(AndroidJUnit4::class)
@LargeTest
class LoginFragmentTest {

    private val UILOAD_DELAY = 2000L

    @Rule
    @JvmField
    var rule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setup() {
        Thread.sleep(UILOAD_DELAY)
    }

    @Test
    fun testTextIsVisible() {
        onView(withId(R.id.otpTv)).check(matches(isDisplayed()))
    }

    @Test
    fun testEditTextIsVisible() {
        onView(withId(R.id.loginEt)).check(matches(isDisplayed()))
    }

    @Test
    fun isKeyboardShown() {
        val inputMethodManager = InstrumentationRegistry.getInstrumentation().targetContext.getSystemService(
            Context.INPUT_METHOD_SERVICE) as InputMethodManager
        Assert.assertTrue(inputMethodManager.isAcceptingText)
    }

    //In the same way, using espresso we can test other UI components.
}
