package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class payment extends AppCompatActivity implements View.OnClickListener {
    public static Boolean recordAddress, recordCreditCard;
    private static Boolean toolCheck = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ImageButton payhomepage = findViewById(R.id.payhomepage);
        payhomepage.setOnClickListener(this);
        int k = globalvariable.numOfac;
        int endnum = globalvariable.numOfOrder-1;
        settlement settle = new settlement();
        TextView extra = findViewById(R.id.extra);
        TextView paymentTotal = findViewById(R.id.paymentTotal);
        extra.setText("免運費");
        paymentTotal.setText("總計： $"+settle.calTotal(globalvariable.ordering, globalvariable.ac[k].getStartnum(), endnum));
        Button confirm = findViewById(R.id.confirm);
        confirm.setOnClickListener(this);
        confirm.setEnabled(false);
        RadioButton pickup, delivery;
        pickup = findViewById(R.id.pickup);
        delivery = findViewById(R.id.delivery);
        CheckBox tool;
        tool = findViewById(R.id.tool);
        TextView tool_ask = findViewById(R.id.tool_ask);
        pickup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if (checked){
                    recordAddress = false;
                    extra.setText("免運費");
                    paymentTotal.setText("總計： $"+settle.calTotal(globalvariable.ordering, globalvariable.ac[k].getStartnum(), endnum));
                    if(recordCreditCard != null)
                        confirm.setEnabled(true);
                }
            }
        });
        delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if (checked){
                    recordAddress = true;
                    extra.setText("運費: $20");
                    paymentTotal.setText("總計： $"+(settle.calTotal(globalvariable.ordering, globalvariable.ac[k].getStartnum(), endnum) + 20));
                    if(recordCreditCard != null)
                        confirm.setEnabled(true);
                }
            }
        });
        tool.setOnClickListener(new View.OnClickListener() { //Waiting for modify
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                switch (v.getId()){
                    case R.id.tool:
                        if (checked)
                        {
                            tool_ask.setText(R.string.tool_true);
                            setToolCheck(true);
                        }
                        else {
                            tool_ask.setText(R.string.tool_false);
                            setToolCheck(false);
                        }
                        break;
                }
            }
        });
        RadioButton Cash,online;
        Cash = findViewById(R.id.Cash);
        online = findViewById(R.id.online);
        Cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if (checked){
                    recordCreditCard = false;
                    if(recordAddress != null)
                        confirm.setEnabled(true);
                }
            }
        });
        online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if (checked){
                    recordCreditCard = true;
                    if(recordAddress != null)
                        confirm.setEnabled(true);
                }
            }
        });
    }
    public void onClick (View v) {
        Intent it = new Intent();
        switch (v.getId()) {
            case R.id.confirm:
                it.setClass(payment.this, personalInformation.class);
                startActivity(it);
                finish();
                break;
            case R.id.payhomepage:
                it.setClass(payment.this, MainActivity.class);
                recordAddress = null;
                recordCreditCard = null;
                startActivity(it);
                finish();

                break;
        }
    }

    public static Boolean getToolCheck() {
        return toolCheck;
    }
    public static void setToolCheck(Boolean input) {
        toolCheck = input;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent it = new Intent();
        it.setClass(payment.this,settlement.class);
        startActivity(it);
        finish();
    }
}