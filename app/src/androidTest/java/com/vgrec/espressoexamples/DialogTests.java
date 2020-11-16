package com.vgrec.espressoexamples;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.vgrec.espressoexamples.activities.DialogExampleActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * @author vgrec, created on 3/24/15.
 */
@RunWith(AndroidJUnit4.class)
public class DialogTests {

    @Rule
    public ActivityTestRule<DialogExampleActivity> mActivityRule =
            new ActivityTestRule<>(DialogExampleActivity.class,
                    true, true);

    @Test
    public void testCheckDialogDisplayed() {
        // Click on the button that shows the dialog
        onView(withId(R.id.confirm_dialog_button)).perform(click());

        // Check the dialog title text is displayed
        onView(withText(R.string.dialog_title)).check(matches(isDisplayed()));
    }

    @Test
    public void testClickOkButton() {
        onView(withId(R.id.confirm_dialog_button)).perform(click());

        // android.R.id.button1 = positive button
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.status_text)).check(matches(withText(R.string.ok)));
    }

    @Test
    public void testClickCancelButton() {
        onView(withId(R.id.confirm_dialog_button)).perform(click());

        // android.R.id.button2 = negative button
        onView(withId(android.R.id.button2)).perform(click());

        onView(withId(R.id.status_text)).check(matches(withText(R.string.cancel)));
    }
}
