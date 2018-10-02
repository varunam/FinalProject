package com.th3snehasish.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.SmallTest;
import com.udacity.gradle.builtidbigger.EndpointsAsyncTask;
import com.udacity.gradle.builtidbigger.MainActivityFragment;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by th3snehasish on 16/08/16.
 */
public class JokesTest extends ApplicationTestCase<Application> {

    CountDownLatch signal;

    public JokesTest() {
        super(Application.class);
    }

    @SmallTest
    public void testJoke() {
        try {
            signal = new CountDownLatch(1);
            MainActivityFragment fragment = MainActivityFragment.newInstance();
            fragment.testFlag = true;
            new EndpointsAsyncTask(getContext()).execute(fragment);
            signal.await(10, TimeUnit.SECONDS);
            assertNotNull("joke is null", fragment.joke_loaded);
            assertFalse("joke is empty", fragment.joke_loaded.isEmpty());
        } catch (Exception ex) {
            fail();
        }
    }
}
