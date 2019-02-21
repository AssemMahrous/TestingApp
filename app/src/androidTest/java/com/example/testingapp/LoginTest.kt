package com.example.testingapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.testingapp.login.LoginActivity
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginTest {

    @get:Rule
    var activityTestRule = ActivityTestRule<LoginActivity>(LoginActivity::class.java)


    @Test
    fun checkViews() {
        onView(withId(R.id.email_input)).check(matches(isDisplayed()))
        onView(withId(R.id.password)).check(matches(isDisplayed()))
        onView(withId(R.id.done_btn)).check(matches(isDisplayed()))
    }

    @Test
    fun checkInteraction() {
        onView(withId(R.id.done_btn)).perform(click())
        onView(ViewMatchers.withText(R.string.fill_inputs)).inRoot(
            RootMatchers.withDecorView(
                Matchers.not(
                    Matchers.`is`
                        (activityTestRule.getActivity().getWindow().getDecorView())
                )
            )
        ).check(matches(isDisplayed()))
    }

    @Test
    fun checkSuccess() {
        onView(withId(R.id.email_input)).perform(replaceText("assem@ibtkar.com"))
        onView(withId(R.id.password)).perform(replaceText("assem"))
        onView(withId(R.id.done_btn)).perform(click())
        onView(withId(R.id.success_text)).check(matches(isDisplayed()))

    }

    @Test
    fun checkInvalidEmail() {
        onView(withId(R.id.email_input)).perform(replaceText("assem"))
        onView(withId(R.id.password)).perform(replaceText("assem"))
        onView(withId(R.id.done_btn)).perform(click())
        onView(ViewMatchers.withText(R.string.wrong_email)).inRoot(
            RootMatchers.withDecorView(
                Matchers.not(
                    Matchers.`is`
                        (activityTestRule.getActivity().getWindow().getDecorView())
                )
            )
        ).check(matches(isDisplayed()))
    }


}