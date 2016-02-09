package com.oreilly.demo.andriod.pa.uidemo.TouchMe;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;

import com.oreilly.demo.android.pa.uidemo.TouchMe;
import com.oreilly.demo.android.pa.uidemo.test.view.AbstractTouchMeActivityTest;


/**
 * Created by Julie Leong on 12/7/2014.
 */
public class TouchMeActivityTest extends ActivityInstrumentationTestCase2<TouchMe> {
    public TouchMeActivityTest() {
        super(TouchMe.class);
        actualTest = new AbstractTouchMeActivityTest(){
            @Override
            protected TouchMe getActivity() {
                // return activity instance provided by instrumentation test
                return TouchMeActivityTest.this.getActivity();
            }
        };
    }

    private AbstractTouchMeActivityTest actualTest;

    public void testActivityCheckTestCaseSetUpProperly() {
        actualTest.testActivityCheckTestCaseSetUpProperly();
    }


    @UiThreadTest
    public void testActivityScenarioRotation()
    {
        actualTest.testActivityScenarioRotation();
    }

}
