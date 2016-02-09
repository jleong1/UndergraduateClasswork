package com.oreilly.demo.android.pa.uidemo.model;

/**
 * Created by Julie Leong on 12/9/2014.
 */
import android.app.Application;
import android.content.Context;

/**
 * Adapted from the class found here:
 * http://www.myandroidsolutions.com/2013/04/27/android-get-application-context/
 * Basically allows the program to get context wherever it is called. Used explicitly in AlarmSoundingState.
 */

public class ApplicationContext extends Application {
    /**
     * Keeps a reference of the application context
     */
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();

        sContext = getApplicationContext();

    }

    // Returns the application context

    public static Context getContext() {
        return sContext;
    }
}