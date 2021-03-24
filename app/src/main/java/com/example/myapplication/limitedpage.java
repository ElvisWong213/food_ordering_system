package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewManager;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class limitedpage extends AppCompatActivity implements View.OnClickListener {
    order store;
    private int amount = 0, price = 92;
    CheckBox porkbelly, cheesericecake, dumplings, greentea, ramune, charsiu, egg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limitedpage);
        ImageButton limitedminus = findViewById(R.id.limitedminus);
        limitedminus.setOnClickListener(this);
        ImageButton limitedplus = findViewById(R.id.limitedplus);
        limitedplus.setOnClickListener(this);
        ImageButton limitedshoppingcart = findViewById(R.id.limitedshoppingcart);
        limitedshoppingcart.setOnClickListener(this);
        ImageButton limitedhomepage = findViewById(R.id.limitedhomepage);
        limitedhomepage.setOnClickListener(this);
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
        TextView limited_amount = findViewById(R.id.limited_amount);
        Intent it = new Intent();
        switch (v.getId()){
            case R.id.limitedminus:
                if (amount > 0) {
                    amount--;
                    store.setOrder_amount(amount);
                }
                else{
                    amount = 0;
                    store.setOrder_amount(amount);
                }
                limited_amount.setText(Integer.toString(amount));
                break;
            case R.id.limitedplus:
                if (amount < 99) {
                    amount++;
                    store.setOrder_amount(amount);
                }
                else{
                    amount = 99;
                    store.setOrder_amount(amount);
                }
                limited_amount.setText(Integer.toString(amount));
                break;
            case R.id.limitedshoppingcart:
                account storeac = globalvariable.registeredInfo[0];
                if(amount!=0){
                    if (globalvariable.firstOrder) {
                        if (!globalvariable.login)
                            globalvariable.ac[k] = new account("","","","","","","");
                        else
                            globalvariable.ac[k] = new account(storeac.getLoginname(),storeac.getPassword(),storeac.getAddress(),storeac.getPhoneno(),storeac.getCreditCard(),storeac.getCVC(),storeac.getValidFrom());
                        globalvariable.firstOrder = false;
                        globalvariable.ac[k].setStartnum(index);
                    }
                    store.setPrice(amount*price);
                    globalvariable.ordering[index] = new order(amount,"limited",store.getPrice(),store.getporkbelly(),store.getcheesericecake(),store.getDumpling(),store.getramune(),store.getgreentea(),store.getEgg(),store.getCharsiu());
                    globalvariable.numOfOrder++;
                    Toast.makeText(limitedpage.this,"小計 $"+Integer.toString(amount*price)+", 已加入購物籃",Toast.LENGTH_LONG).show();
                }
            case R.id.limitedhomepage:
                it.setClass(limitedpage.this,MainActivity.class);
                startActivity(it);
                finish();
                break;
        }
    }
}