package com.edelweiss.nikhilnagpure.findgarage.spalsh;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.edelweiss.nikhilnagpure.findgarage.BaseActivity;
import com.edelweiss.nikhilnagpure.findgarage.Control;
import com.edelweiss.nikhilnagpure.findgarage.HomeActivity;
import com.edelweiss.nikhilnagpure.findgarage.R;
import com.edelweiss.nikhilnagpure.findgarage.login.LoginActivity;

public class SplashActivity extends BaseActivity {
    private Handler handler = new Handler();
    private View fullscreen_content;
    private Runnable runnable;
    private Activity activity;
    private Runnable hidePartRunnable;
    private Runnable hideRunnable;
    private Intent homeScreenIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
        delayedHide(Control.SPLASH_SCREEN_TIME);
    }

    private void init() {
        fullscreen_content = findViewById(R.id.fullscreen_content);
        activity = this;
        homeScreenIntent = new Intent(activity, LoginActivity.class);

        runnable = new Runnable() {
            @Override
            public void run() {
                activity.startActivity(homeScreenIntent);
                activity.finish();

            }
        };

        hidePartRunnable = new Runnable() {
            @SuppressLint("InlinedApi")
            @Override
            public void run() {

                try {
                    fullscreen_content.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        hideRunnable = new Runnable() {
            @Override
            public void run() {
                hide();
            }
        };


    }


    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        handler.post(hidePartRunnable);
    }


    private void delayedHide(int delayMillis) {
        handler.removeCallbacks(hideRunnable);
        handler.post(hideRunnable);
        handler.postDelayed(runnable,delayMillis);
    }
}
