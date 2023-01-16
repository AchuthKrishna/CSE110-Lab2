package edu.ucsd.cse110.lab2;

import org.junit.Test;

import static org.junit.Assert.*;

import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void should_always_pass() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void test_one_plus_one_equals_two() {
        var scenario = ActivityScenario.launch(MainActivity.class);
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);

        scenario.onActivity(activity -> {
            Button btn1 = activity.findViewById(R.id.btn_one);
            Button plus = activity.findViewById(R.id.btn_plus);
            Button equal = activity.findViewById(R.id.btn_equals);

            btn1.performClick();
            plus.performClick();
            btn1.performClick();
            equal.performClick();

            TextView disp = activity.findViewById(R.id.display);

            assertEquals(2, disp.getText());
        });
    }
}