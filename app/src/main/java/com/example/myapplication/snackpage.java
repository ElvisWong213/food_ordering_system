package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class snackpage extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackpage);
        ImageButton snackhomepage = findViewById(R.id.drinkhomepage);
        snackhomepage.setOnClickListener(this);

    }

    public void onClick (View v){
        Intent it = new Intent();
        switch (v.getId()){
            case R.id.drinkhomepage:
                it.setClass(snackpage.this,MainActivity.class);
                startActivity(it);
                finish();
                break;

        }
    }
}