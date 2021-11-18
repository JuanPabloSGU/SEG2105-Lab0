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

@RunWith(AndroidJUnit4.class)
public class edgeCasesCalculatorTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void negativeNum(){
        onView(withId(R.id.btnSub)).perform(click());
        onView(withId(R.id.btn4)).perform(click());
        onView(withId(R.id.btnMul)).perform(click());
        onView(withId(R.id.btn2)).perform(click());
        onView(withId(R.id.btnEql)).perform(click());

        onView(withId(R.id.display)).check(matches(withText("-8")));

    }

    @Test
    public void bedmass(){
        onView(withId(R.id.btn4)).perform(click());
        onView(withId(R.id.btnAdd)).perform(click());
        onView(withId(R.id.btn6)).perform(click());
        onView(withId(R.id.btnDiv)).perform(click());
        onView(withId(R.id.btn3)).perform(click());
        onView(withId(R.id.btnEql)).perform(click());

        onView(withId(R.id.display)).check(matches(withText("6")));
    }

    @Test
    public void decimals(){
        onView(withId(R.id.btn5)).perform(click());
        onView(withId(R.id.btnDec)).perform(click());
        onView(withId(R.id.btn8)).perform(click());
        onView(withId(R.id.btnAdd)).perform(click());
        onView(withId(R.id.btn7)).perform(click());
        onView(withId(R.id.btnEql)).perform(click());

        onView(withId(R.id.display)).check(matches(withText("12.8")));
    }
}
