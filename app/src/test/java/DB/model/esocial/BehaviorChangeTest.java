package DB.model.esocial;

import junit.extensions.ActiveTestSuite;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;


@RunWith(value = JUnit4.class)
public class BehaviorChangeTest {
    private String stringExperiment;


    @Rule
    public ActivityTestRule<MainActivity>activityTestRule = new ActivityTestRule(MainActivity);

    @Before
    public void initValidString()
    {
        stringExperiment = "Basic Test";
    }

    @Test
    public void changeText_SameActivity()
    {
        onView(withID(R.id.edit_user)).perform(typeText(stringExperiment), closeSoftKeyboard());
        onView(withID(R.id.changeTextBt)).perform(click());

        // check if data change
        onView(withID(R.id.textToBeChanged)).check(matches(withText(stringExperiment)));
    }



}
