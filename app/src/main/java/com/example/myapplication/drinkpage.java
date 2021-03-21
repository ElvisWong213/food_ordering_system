package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class drinkpage extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinkpage);
        ImageButton drinkhomepage = findViewById(R.id.drinkhomepage);
        drinkhomepage.setOnClickListener(this);
    }

    public void onClick (View v){
        Intent it = new Intent();
        switch (v.getId()){
            case R.id.drinkhomepage:
                it.setClass(drinkpage.this,MainActivity.class);
                startActivity(it);
                finish();
                break;

        }
    }
}