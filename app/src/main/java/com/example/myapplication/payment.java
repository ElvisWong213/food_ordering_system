package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class payment extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ImageButton payhomepage = findViewById(R.id.payhomepage);
        payhomepage.setOnClickListener(this);
    }
    public void onClick (View v) {
        Intent it = new Intent();
        switch (v.getId()){
            case R.id.payhomepage:
                it.setClass(payment.this,MainActivity.class);
                startActivity(it);
                finish();
                break;
        }
    }
}