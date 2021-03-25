package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button withoutLogin = findViewById(R.id.withoutLogin);
        withoutLogin.setOnClickListener(this);
        Button loginButton = findViewById(R.id.login);
        loginButton.setOnClickListener(this);
        globalvariable.registeredInfo[0] = new account("SteveWong","19060186A","8 Hung Lok Road, Hung Hom, Kowloon","37460123","4539660340296451","201","22/05");
    }
    public void onClick (View v) {
        Intent it = new Intent();
        EditText usernameEditText = findViewById(R.id.username);
        EditText passwordEditText = findViewById(R.id.password);
        switch (v.getId()){
            case R.id.withoutLogin:
                it.setClass(LoginActivity.this, MainActivity.class);
                startActivity(it);
                finish();
                break;
            case R.id.login:
                if (usernameEditText.getText().toString().equals("SteveWong") && passwordEditText.getText().toString().equals("19060186A"))
                {
                    globalvariable.login =true;
                    it.setClass(LoginActivity.this, MainActivity.class);
                    startActivity(it);
                    finish();
                }
                else if(usernameEditText.getText().toString().equals("restaurant") && passwordEditText.getText().toString().equals("123")) {
                    it.setClass(LoginActivity.this, RestaurantMainActivity.class);
                    startActivity(it);
                    finish();
                }
                else
                    {
                    Toast.makeText(LoginActivity.this, "用戶名稱或密碼錯誤", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

}