package com.mllab.sehh3143groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton imblz120 = findViewById(R.id.imblz120);
        imblz120.setOnClickListener(this);
        Button lz120 = findViewById(R.id.white);
        lz120.setOnClickListener(this);
    }

public void onClick(View v){
    Intent it = new Intent();
    switch (v.getId()){
        case R.id.imblz120:
            it.setClass(MainActivity.this,lz120page.class);
            startActivity(it);
            finish();
            break;
        case R.id.white:
            it.setClass(MainActivity.this,lz120page.class);
            startActivity(it);
            finish();
            break;
    }
}
}