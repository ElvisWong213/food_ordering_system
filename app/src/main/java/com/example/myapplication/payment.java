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
    boolean recordAddress = false, recordCreditCard = false;
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
        switch (pickup_or_delivery.getCheckedRadioButtonId()){
            case R.id.pickup:
                recordAddress = false;
                break;
            case R.id.delivery:
                recordAddress = true;
                break;
        }
        RadioGroup cash_or_online = findViewById(R.id.cash_or_online);
        switch ((cash_or_online.getCheckedRadioButtonId())){
            case R.id.Cash:
                recordCreditCard = false;
                break;
            case R.id.online:
                recordCreditCard = true;
                break;
        }
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