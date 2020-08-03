package com.torrentcome.lalala

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.torrentcome.lalala.ui.random.RandomActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    var mActivityTestRule: ActivityTestRule<RandomActivity> =
        ActivityTestRule(RandomActivity::class.java, true, false)

    @Before
    fun setUp() {
        val intent = Intent()
        mActivityTestRule.launchActivity(intent)
    }

    @Test
    fun whenPassTheSplashScreen() {
        onView(withId(R.id.button)).check(matches(isDisplayed()))
        onView(withId(R.id.button)).perform((click()))
    }

    @Test
    fun whenPassThenTypeCoolInSearch() {
        whenPassTheSplashScreen()
        onView(withId(R.id.edit)).check(matches(isDisplayed()))
        onView(withId(R.id.edit)).perform(clearText(), typeText("cool"))
        pauseTestFor(2000)
    }

    @Test
    fun whenCoolThenClick() {
        whenPassThenTypeCoolInSearch()
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
        onView(withId(R.id.recycler_view)).perform(
            actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
    }

    @Test
    fun whenSwipeUpThenSwipeLeft() {
        whenCoolThenClick()
    }


    private fun pauseTestFor(milliseconds: Long) {
        try {
            Thread.sleep(milliseconds)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}
