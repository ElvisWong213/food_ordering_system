package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class lz120page extends AppCompatActivity implements View.OnClickListener {
    public int total = 0;
    private int amount = 0, price = 72;
    CheckBox porkbelly, cheesericecake, dumplings, greentea, ramune;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lz120page);

        globalvariable.ordering[globalvariable.numOfOrder] = new order(0,"white", 0,false,false,false,false,false);
        ImageButton whiteminus = findViewById(R.id.whiteminus);
        whiteminus.setOnClickListener(this);
        ImageButton whiteplus = findViewById(R.id.whiteplus);
        whiteplus.setOnClickListener(this);
        ImageButton whiteshoppingcart = findViewById(R.id.whiteshoppingcart);
        whiteshoppingcart.setOnClickListener(this);
        porkbelly = findViewById(R.id.porkBelly);
        porkbelly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                switch (v.getId()) {
                    case R.id.porkBelly:
                        if (checked)
                        {
                            price += 25;
                            order.setporkbelly(true);
                        }
                        else
                        {price -= 25;
                            order.setporkbelly(false);}
                        break;
                }
            }
        });
        cheesericecake = findViewById(R.id.cheeseRicecake);
        cheesericecake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                switch (v.getId()){
                    case R.id.cheeseRicecake:
                        if (checked)
                        {price += 12;
                            order.setCheesericecake(true);}
                        else
                        {price -= 12;
                            order.setCheesericecake(false);}
                        break;
                }
            }
        });
        dumplings = findViewById(R.id.dumplings);
        dumplings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                switch (v.getId()){
                    case R.id.dumplings:
                        if (checked)
                        {price += 30;
                            order.setDumplings(true);}
                        else
                        {price -= 30;
                            order.setDumplings(false);}
                        break;
                }
            }
        });
        greentea = findViewById(R.id.greentea);
        greentea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                switch (v.getId()){
                    case R.id.greentea:
                        if (checked) {
                            price += 18;
                            order.setGreentea(true);
                        }
                        else {
                            price -= 18;
                            order.setGreentea(false);
                        }
                        break;
                }
            }
        });
        ramune = findViewById(R.id.ramune);
        ramune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                switch (v.getId()){
                    case R.id.ramune:
                        if (checked)
                        {
                            price += 20;
                            order.setRamune(true);
                        }
                        else {
                            price -= 20;
                            order.setRamune(false);
                        }
                        break;
                }
            }
        });
    }
    public void onClick (View v){

        TextView white_amount = findViewById(R.id.white_amount);
        Intent it = new Intent();
        switch (v.getId()){
            case R.id.whiteminus:
                if (amount > 0) {
                    amount--;
                    order.setOrder_amount(amount);
                }
                else{
                    amount = 0;
                    order.setOrder_amount(amount);
                }
                white_amount.setText(Integer.toString(amount));
                break;
            case R.id.whiteplus:
                if (amount < 99) {
                    amount++;
                    order.setOrder_amount(amount);
                }
                else{
                    amount = 99;
                    order.setOrder_amount(amount);
                }
                white_amount.setText(Integer.toString(amount));
                break;
            case R.id.whiteshoppingcart:
                if(amount!=0){
                    globalvariable.numOfOrder++;
                    Toast.makeText(lz120page.this,"Total amount is: "+Integer.toString(amount*price),Toast.LENGTH_LONG).show();
                }
                it.setClass(lz120page.this,MainActivity.class);
                startActivity(it);
                finish();
                break;
        }
    }
}