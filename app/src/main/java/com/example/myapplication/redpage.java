package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class redpage extends AppCompatActivity implements View.OnClickListener {
    order store;
    private int amount = 0, price = 82;
    CheckBox porkbelly, cheesericecake, dumplings, greentea, ramune, charsiu, egg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redpage);
        ImageButton redminus = findViewById(R.id.redminus);
        redminus.setOnClickListener(this);
        ImageButton redplus = findViewById(R.id.redplus);
        redplus.setOnClickListener(this);
        ImageButton redshoppingcart = findViewById(R.id.redshoppingcart);
        redshoppingcart.setOnClickListener(this);
        ImageButton redhomepage = findViewById(R.id.redhomepage);
        redhomepage.setOnClickListener(this);
        store = new order(0,"",0,false,false,false,false,false, false, false);
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
                            store.setporkbelly(true);
                        }
                        else
                        {price -= 25;
                            store.setporkbelly(false);}
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
                            store.setCheesericecake(true);}
                        else
                        {price -= 12;
                            store.setCheesericecake(false);}
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
                            store.setDumplings(true);}
                        else
                        {price -= 30;
                            store.setDumplings(false);}
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
                            store.setGreentea(true);
                        }
                        else {
                            price -= 18;
                            store.setGreentea(false);
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
                            store.setRamune(true);
                        }
                        else {
                            price -= 20;
                            store.setRamune(false);
                        }
                        break;
                }
            }
        });
        egg = findViewById(R.id.egg);
        egg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                switch (v.getId()){
                    case R.id.egg:
                        if (checked)
                        {
                            price += 6;
                            store.setEgg(true);
                        }
                        else {
                            price -= 6;
                            store.setEgg(false);
                        }
                        break;
                }
            }
        });
        charsiu = findViewById(R.id.Charsiu);
        charsiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                switch (v.getId()){
                    case R.id.Charsiu:
                        if (checked)
                        {
                            price += 18;
                            store.setCharsiu(true);
                        }
                        else {
                            price -= 18;
                            store.setCharsiu(false);
                        }
                        break;
                }
            }
        });
    }
    public void onClick (View v){
        int index = globalvariable.numOfOrder;
        int k = globalvariable.numOfac;
        TextView red_amount = findViewById(R.id.red_amount);
        Intent it = new Intent();
        switch (v.getId()){
            case R.id.redminus:
                if (amount > 0) {
                    amount--;
                    store.setOrder_amount(amount);
                }
                else{
                    amount = 0;
                    store.setOrder_amount(amount);
                }
                red_amount.setText(Integer.toString(amount));
                break;
            case R.id.redplus:
                if (amount < 99) {
                    amount++;
                    store.setOrder_amount(amount);
                }
                else{
                    amount = 99;
                    store.setOrder_amount(amount);
                }
                red_amount.setText(Integer.toString(amount));
                break;
            case R.id.redshoppingcart:
                if(amount!=0){
                    if (globalvariable.firstOrder) {
                        if (!globalvariable.login)
                        globalvariable.ac[k] = new account("","","","");
                        globalvariable.firstOrder = false;
                        globalvariable.ac[k].setStartnum(index);
                    }
                    store.setPrice(amount*price);
                    globalvariable.ordering[index] = new order(amount,"red",store.getPrice(),store.getporkbelly(),store.getcheesericecake(),store.getDumpling(),store.getramune(),store.getgreentea(),store.getEgg(),store.getCharsiu());
                    globalvariable.numOfOrder++;
                    Toast.makeText(redpage.this,"Total amount is: "+Integer.toString(amount*price),Toast.LENGTH_LONG).show();
                }
            case R.id.redhomepage:
                it.setClass(redpage.this,MainActivity.class);
                startActivity(it);
                finish();
                break;
        }
    }
}