package com.oreilly.demo.android.pa.uidemo.test.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import android.content.pm.ActivityInfo;
import android.widget.TextView;
import com.oreilly.demo.android.pa.uidemo.TouchMe;
import com.oreilly.demo.android.pa.uidemo.R;

/**
 * Created by Julie Leong on 12/7/2014.
 */
//still working on it...
public abstract class AbstractTouchMeActivityTest {

    @Test
    public void testActivityCheckTestCaseSetUpProperly() {
        assertNotNull("activity should be launched successfully", getActivity());
    }

    protected abstract TouchMe getActivity();

    @Test
    public void testActivityScenarioRotation()
    {
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}
