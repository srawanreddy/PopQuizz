package com.example.sravanreddy.popquizz;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class SplashScreen extends Activity {
    View viewProgress;
    AnimationSet animationSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        viewProgress = findViewById(R.id.view_progress);
        int viewWidth = viewProgress.getWidth();

        TranslateAnimation move = new TranslateAnimation(-(getScreenWidth() / 2) + viewWidth / 2, (getScreenWidth() / 2) + viewWidth / 2 + viewWidth, 0, 0);
        move.setDuration(1000);
        TranslateAnimation move1 = new TranslateAnimation(-viewWidth, 0, 0, 0);
        move1.setDuration(500);
        ScaleAnimation laftOut = new ScaleAnimation(0, 1, 1, 1);
        laftOut.setDuration(500);

        animationSet = new AnimationSet(true);
        animationSet.addAnimation(move);
        animationSet.addAnimation(move1);
        animationSet.addAnimation(laftOut);
        animationSet.addAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slideout));

        startAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);

    }
    private void startAnimation() {
        viewProgress.startAnimation(animationSet);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startAnimation();
            }
        }, 1000);
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }
}

