package com.example.rahulkapoor.sampleassignment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * splash screen;
 */
public class SplashActivity extends Activity {

    private static final int SPLASH_TIME_OUT = 2000;
    private Intent mIntent;

    /**
     * @param savedInstanceState save instance state;
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            /**
             * calls run after the splash time out;
             */
            @Override
            public void run() {
                mIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(mIntent);

            }
        }, SPLASH_TIME_OUT);
    }

}
