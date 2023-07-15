package com.tie.fantasyking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.firebase.messaging.FirebaseMessaging;
import com.tie.fantasyking.databinding.ActivitySplashBinding;

import java.util.Objects;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {
    ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        FirebaseMessaging.getInstance().subscribeToTopic("all");

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

//binding.linearLayout.animate().rotationY(-1400).setDuration(2700).setStartDelay(0);

//        binding.linearLayout.animate().setDuration(2700).setDuration(0);
//        binding.ivAppLogo.animate().setDuration(2700).setDuration(0);
//        binding.ivAppLogo.animate().rotationY(1000).setDuration(1000).setStartDelay(2900);
        Animation animation = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.animation1);
        binding.linearLayout.startAnimation(animation);

        Animation animation2 = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.animation2);
        binding.ivAppLogo.startAnimation(animation2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        }, 5000);



    }





}