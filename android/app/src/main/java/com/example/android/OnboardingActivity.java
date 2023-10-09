package com.example.android;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OnboardingActivity extends AppCompatActivity {
    private int clickCount = 0;
    private Button onboardingButton;
    private TextView onboardingContentTextView;
    private ImageView onboardingContentImageView, dot1, dot2, dot3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        onboardingButton = findViewById(R.id.onboardingButton);
        onboardingContentImageView = findViewById(R.id.onboardingImageContent);
        onboardingContentTextView = findViewById(R.id.onboardingTextContent);
        dot1 = findViewById(R.id.dot1);
        dot2 = findViewById(R.id.dot2);
        dot3 = findViewById(R.id.dot3);

        onboardingButton.setOnClickListener(v -> {
            if (clickCount == 0) {
                animateTextAndImageChange(R.string.onboarding_contentText2, R.drawable.blog_onboarding2);
                dotStateChange(clickCount);
                clickCount++;
            } else if (clickCount == 1) {
                animateTextAndImageChange(R.string.onboarding_contentText3, R.drawable.blog_onboarding3);
                onboardingButton.setText(R.string.onboarding_to_auth_txt);
                dotStateChange(clickCount);
                clickCount++;
            } else if (clickCount == 2) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });
    }

    private void animateTextAndImageChange(int textResource, int imageResource) {
        ObjectAnimator textFadeOut = ObjectAnimator.ofFloat(onboardingContentTextView, "alpha", 1f, 0f);
        textFadeOut.setDuration(400);
        textFadeOut.start();

        ObjectAnimator imageFadeOut = ObjectAnimator.ofFloat(onboardingContentImageView, "alpha", 1f, 0f);
        imageFadeOut.setDuration(400);
        imageFadeOut.start();

        textFadeOut.addUpdateListener(animation -> {
            if ((float) animation.getAnimatedValue() == 0f) {
                onboardingContentTextView.setText(textResource);
                onboardingContentImageView.setImageResource(imageResource);
                ObjectAnimator textFadeIn = ObjectAnimator.ofFloat(onboardingContentTextView, "alpha", 0f, 1f);
                textFadeIn.setDuration(400); // Duration in milliseconds
                textFadeIn.start();

                ObjectAnimator imageFadeIn = ObjectAnimator.ofFloat(onboardingContentImageView, "alpha", 0f, 1f);
                imageFadeIn.setDuration(400); // Duration in milliseconds
                imageFadeIn.start();
            }
        });
    }

    private void dotStateChange(int val) {
        if (val == 0) {
            dot1.setImageResource(R.drawable.indicator_dot_unselected);
            dot2.setImageResource(R.drawable.indicator_dot);
            dot3.setImageResource(R.drawable.indicator_dot_unselected);
        } else if (val == 1) {
            dot1.setImageResource(R.drawable.indicator_dot_unselected);
            dot2.setImageResource(R.drawable.indicator_dot_unselected);
            dot3.setImageResource(R.drawable.indicator_dot);
        }
    }
}
