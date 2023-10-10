package com.example.android;

import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.android.Utils.UtilityMethods;

public class SignupActivity extends AppCompatActivity {

    AppCompatButton signupButton, loginButton;
    ImageView showPassword;
    boolean isShowPassword = false;
    EditText Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        loginButton = findViewById(R.id.toLogin);
        showPassword = findViewById(R.id.showPassword);
        Password = findViewById(R.id.password);

        loginButton.setOnClickListener(v -> openLoginActivity());
        showPassword.setOnClickListener(v -> showPasswordFunctionality());
    }

    private void showPasswordFunctionality() {
        if (!isShowPassword) {
            Password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            showPassword.setImageResource(R.drawable.ic_hide_password);
            isShowPassword = true;
        } else {
            Password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            showPassword.setImageResource(R.drawable.ic_show_password);
            isShowPassword = false;
        }
        Password.setSelection(Password.getText().length());
    }

    private void openLoginActivity() {
        UtilityMethods utilityMethods = new UtilityMethods();
        utilityMethods.openActivity(SignupActivity.this, LoginActivity.class);
    }
}
