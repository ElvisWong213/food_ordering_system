package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class payment extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ImageButton payhomepage = findViewById(R.id.payhomepage);
        payhomepage.setOnClickListener(this);
        int k = globalvariable.numOfac;
        int endnum = globalvariable.numOfOrder-1;
        settlement settle = new settlement();
        TextView paymentTotal = findViewById(R.id.paymentTotal);
        paymentTotal.setText("總計： $"+settle.calTotal(globalvariable.ordering, globalvariable.ac[k].getStartnum(), endnum));
        Button confirm = findViewById(R.id.confirm);
        confirm.setOnClickListener(this);
    }
    public void onClick (View v) {
        Intent it = new Intent();
        switch (v.getId()){
            case R.id.confirm:
                globalvariable.numOfac++;
                globalvariable.firstOrder = true;
            case R.id.payhomepage:
                it.setClass(payment.this,MainActivity.class);
                startActivity(it);
                finish();
                break;
        }
    }
}