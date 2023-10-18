package com.example.android;

import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.android.Utils.UtilityMethods;

public class LoginActivity extends AppCompatActivity {

    AppCompatButton loginButton, signupButton;
    ImageView showPassword;
    EditText Password;
    boolean isShowPassword = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        showPassword = findViewById(R.id.showPassword);
        Password = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);
        signupButton = findViewById(R.id.toSignup);

        showPassword.setOnClickListener(v -> showPasswordFunctionality());
        signupButton.setOnClickListener(v -> openSignupActivity());
    }

    private void openSignupActivity() {
        UtilityMethods utilityMethods = new UtilityMethods();
        utilityMethods.openActivity(LoginActivity.this, SignupActivity.class);
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
}
