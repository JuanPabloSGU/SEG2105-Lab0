package com.example.simplecalculator;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class calculatorTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void addition() {

        // Testing addition
        onView(withId(R.id.btn2)).perform(click());
        onView(withId(R.id.btnAdd)).perform(click());
        onView(withId(R.id.btn2)).perform(click());
        onView(withId(R.id.btnEql)).perform(click());

        onView(withId(R.id.display)).check(matches(withText("4")));
    }

    @Test
    public void subtraction(){
        // Testing subtraction
        onView(withId(R.id.btn4)).perform(click());
        onView(withId(R.id.btnSub)).perform(click());
        onView(withId(R.id.btn1)).perform(click());
        onView(withId(R.id.btnEql)).perform(click());

        onView(withId(R.id.display)).check(matches(withText("3")));

    }

    @Test
    public void multiplication(){
        // Testing multiplication
        onView(withId(R.id.btn2)).perform(click());
        onView(withId(R.id.btnMul)).perform(click());
        onView(withId(R.id.btn2)).perform(click());
        onView(withId(R.id.btnEql)).perform(click());

        onView(withId(R.id.display)).check(matches(withText("4")));

    }

    @Test
    public void division(){
        // Testing Division
        onView(withId(R.id.btn4)).perform(click());
        onView(withId(R.id.btnDiv)).perform(click());
        onView(withId(R.id.btn2)).perform(click());
        onView(withId(R.id.btnEql)).perform(click());

        onView(withId(R.id.display)).check(matches(withText("2")));
    }

}