package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton imwhite = findViewById(R.id.imwhite);
        imwhite.setOnClickListener(this);
        Button white = findViewById(R.id.white);
        white.setOnClickListener(this);
        ImageButton imred = findViewById(R.id.imred);
        imred.setOnClickListener(this);
        Button red = findViewById(R.id.red);
        red.setOnClickListener(this);
        ImageButton viewshoppingcart = findViewById(R.id.viewshoppingcart);
        viewshoppingcart.setOnClickListener(this);
    }

    public void onClick(View v){
        Intent it = new Intent();
        switch (v.getId()){
            case R.id.imwhite:
            case R.id.white:
                it.setClass(MainActivity.this,lz120page.class);
                startActivity(it);
                finish();
                break;
            case R.id.imred:
            case R.id.red:
                break;
            case R.id.viewshoppingcart:
                it.setClass(MainActivity.this,settlement.class);
                startActivity(it);
                finish();
                break;
        }
    }
}