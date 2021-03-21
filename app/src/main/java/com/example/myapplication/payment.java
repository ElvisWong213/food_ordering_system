package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class payment extends AppCompatActivity implements View.OnClickListener {
    public static boolean recordAddress = false, recordCreditCard = false;
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
        RadioGroup pickup_or_delivery = findViewById(R.id.pickup_or_delivery);
        RadioButton pickup, delivery;
        pickup = findViewById(R.id.pickup);
        delivery = findViewById(R.id.delivery);
        pickup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if (checked){
                    recordAddress = false;
                }
            }
        });
        delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if (checked){
                    recordAddress = true;
                }
            }
        });
        RadioGroup cash_or_online = findViewById(R.id.cash_or_online);
        RadioButton Cash,online;
        Cash = findViewById(R.id.Cash);
        online = findViewById(R.id.online);
        Cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if (checked){
                    recordCreditCard = false;
                }
            }
        });
        online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if (checked){
                    recordCreditCard = true;
                }
            }
        });
    }
    public void onClick (View v) {
        Intent it = new Intent();
        switch (v.getId()){
            case R.id.confirm:
                if(!globalvariable.login) {
                    it.setClass(payment.this,personalInformation.class);
                    startActivity(it);
                    finish();
                    break;
                }
                else {
                    globalvariable.numOfac++;
                    globalvariable.firstOrder = true;
                }
            case R.id.payhomepage:
                it.setClass(payment.this,MainActivity.class);
                startActivity(it);
                finish();
                break;
        }
    }
}