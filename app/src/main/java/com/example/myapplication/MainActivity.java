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
        ImageButton imblack = findViewById(R.id.imblack);
        imblack.setOnClickListener(this);
        Button black = findViewById(R.id.black);
        black.setOnClickListener(this);
        ImageButton imlimited = findViewById(R.id.imlimited);
        imlimited.setOnClickListener(this);
        Button limited = findViewById(R.id.limited);
        limited.setOnClickListener(this);
        ImageButton imsnack = findViewById(R.id.imsnack);
        imsnack.setOnClickListener(this);
        Button snack = findViewById(R.id.snack);
        snack.setOnClickListener(this);
        ImageButton imdrink = findViewById(R.id.imdrink);
        imdrink.setOnClickListener(this);
        Button drink = findViewById(R.id.drink);
        drink.setOnClickListener(this);

        ImageButton viewshoppingcart = findViewById(R.id.viewshoppingcart);
        viewshoppingcart.setOnClickListener(this);
        Button toRestaurant = findViewById(R.id.toRestaurant);
        toRestaurant.setOnClickListener(this);
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
            case R.id.imblack:
            case R.id.black:
                break;
            case R.id.imlimited:
            case R.id.limited:
                break;
            case R.id.imdrink:
            case R.id.drink:
                break;
            case R.id.imsnack:
            case R.id.snack:
                break;

            case R.id.viewshoppingcart:
                it.setClass(MainActivity.this,settlement.class);
                startActivity(it);
                finish();
                break;
            case R.id.toRestaurant:
                it.setClass(MainActivity.this,RestaurantMainActivity.class);
                startActivity(it);
                finish();
                break;
        }
    }
}