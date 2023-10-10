package com.example.android.Utils;

import android.app.Activity;
import android.content.Intent;

public class UtilityMethods {
    public void openActivity(Activity activity, Class<?> targetActivityClass) {
        Intent intent = new Intent(activity, targetActivityClass);
        activity.startActivity(intent);
        activity.overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        activity.finish();
    }
}
