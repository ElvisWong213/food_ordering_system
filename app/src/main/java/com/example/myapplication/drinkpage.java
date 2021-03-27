package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class drinkpage extends AppCompatActivity implements View.OnClickListener {
    order store;
    RadioButton Rramune, Rgreentea;
    private int amount = 0, price = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinkpage);
        ImageButton drinkminus = findViewById(R.id.drinkminus);
        drinkminus.setOnClickListener(this);
        ImageButton drinkplus = findViewById(R.id.drinkplus);
        drinkplus.setOnClickListener(this);
        ImageButton drinkshoppingcart = findViewById(R.id.drinkshoppingcart);
        drinkshoppingcart.setOnClickListener(this);
        ImageButton drinkhomepage = findViewById(R.id.drinkhomepage);
        drinkhomepage.setOnClickListener(this);
        Rramune = findViewById(R.id.Rramune);
        Rgreentea = findViewById(R.id.Rgreentea);
        store = new order(0,"",0,false,false,false,false,false, false, false);
        Rramune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if (checked){
                    store.setRamune(true);
                    store.setGreentea(false);
                    price = 23;
                }
            }
        });
        Rgreentea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if (checked){
                    store.setRamune(false);
                    store.setGreentea(true);
                    price = 21;
                }
            }
        });
    }

    public void onClick (View v){
        int index = globalvariable.numOfOrder;
        int k = globalvariable.numOfac;
        TextView drink_amount = findViewById(R.id.drink_amount);
        Intent it = new Intent();
        switch (v.getId()){
            case R.id.drinkminus:
                if (amount > 0) {
                    amount--;
                    store.setOrder_amount(amount);
                }
                else{
                    amount = 0;
                    store.setOrder_amount(amount);
                }
                drink_amount.setText(Integer.toString(amount));
                break;
            case R.id.drinkplus:
                if (amount < 99) {
                    amount++;
                    store.setOrder_amount(amount);
                }
                else{
                    amount = 99;
                    store.setOrder_amount(amount);
                }
                drink_amount.setText(Integer.toString(amount));
                break;
            case R.id.drinkshoppingcart:
                account storeac = globalvariable.registeredInfo[0];
                if(amount!=0 && (store.getramune() || store.getgreentea())){
                    if (globalvariable.firstOrder) {
                        if (!globalvariable.login)
                            globalvariable.ac[k] = new account("","","","","","","");
                        else
                            globalvariable.ac[k] = new account(storeac.getLoginname(),storeac.getPassword(),storeac.getAddress(),storeac.getPhoneno(),storeac.getCreditCard(),storeac.getCVC(),storeac.getValidFrom());
                        globalvariable.firstOrder = false;
                        globalvariable.ac[k].setStartnum(index);
                    }
                    store.setPrice(amount*price);
                    globalvariable.ordering[index] = new order(amount,"null",store.getPrice(),store.getporkbelly(),store.getcheesericecake(),store.getDumpling(),store.getramune(),store.getgreentea(),store.getEgg(),store.getCharsiu());
                    globalvariable.ordering[index].setSingleprice(price);
                    globalvariable.numOfOrder++;
                    Toast.makeText(drinkpage.this,"小計 $"+Integer.toString(amount*price)+", 已加入購物籃",Toast.LENGTH_SHORT).show();
                }
            case R.id.drinkhomepage:
                it.setClass(drinkpage.this,MainActivity.class);
                startActivity(it);
                finish();
                break;

        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent it = new Intent();
        it.setClass(drinkpage.this,MainActivity.class);
        startActivity(it);
        finish();
    }
}