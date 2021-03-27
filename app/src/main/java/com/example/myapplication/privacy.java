package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class privacy extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);
        ImageButton privacyhomepage = findViewById(R.id.privacypage);
        privacyhomepage.setOnClickListener(this);
    }
    public void onClick (View v){
        Intent it = new Intent();
        switch (v.getId()){
            case R.id.privacypage:
                it.setClass(privacy.this,shop.class);
                startActivity(it);
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent it = new Intent();
        it.setClass(privacy.this,shop.class);
        startActivity(it);
        finish();
    }
}