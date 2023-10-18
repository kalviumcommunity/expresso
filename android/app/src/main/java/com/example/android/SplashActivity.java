package com.example.android;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.Utils.UtilityMethods;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    private final String logoText = "Expresso";
    private TextView logoTextView;
    private int charIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logoTextView = findViewById(R.id.appName);

        animateTextTypewriter();
    }

    private void animateTextTypewriter() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (charIndex <= logoText.length()) {
                    logoTextView.setText(logoText.subSequence(0, charIndex));
                    charIndex++;
                    handler.postDelayed(this, 50);
                } else {
                    handler.postDelayed(() -> {
                        UtilityMethods utilityMethods = new UtilityMethods();
                        utilityMethods.openActivity(SplashActivity.this, OnboardingActivity.class);
                    }, 1000);
                }
            }
        }, 10);
    }
}
