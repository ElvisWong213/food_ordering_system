package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class personalInformation extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);
        ImageButton PIhomepage = findViewById(R.id.PIhomepage);
        PIhomepage.setOnClickListener(this);
    }

    public void onClick(View v){
        Intent it = new Intent();
        switch (v.getId()){
            case R.id.PIhomepage:
                it.setClass(personalInformation.this,MainActivity.class);
                startActivity(it);
                finish();
        }
    }
}