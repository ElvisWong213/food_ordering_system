package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class snackpage extends AppCompatActivity implements View.OnClickListener {
    order store;
    RadioButton Rporkbelly, Rcheeserickcake, Rdumpling;
    private int amount = 0, price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackpage);
        ImageButton snackminus = findViewById(R.id.snackminus);
        snackminus.setOnClickListener(this);
        ImageButton snackplus = findViewById(R.id.snackplus);
        snackplus.setOnClickListener(this);
        ImageButton snackshoppingcart = findViewById(R.id.snackshoppingcart);
        snackshoppingcart.setOnClickListener(this);
        ImageButton snackhomepage = findViewById(R.id.snackhomepage);
        snackhomepage.setOnClickListener(this);
        store = new order(0,"",0,false,false,false,false,false, false, false);
        Rporkbelly = findViewById(R.id.Rporkbelly);
        Rcheeserickcake = findViewById(R.id.Rcheesericecake);
        Rdumpling = findViewById(R.id.Rdumpling);
        Rporkbelly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if (checked){
                    store.setporkbelly(true);
                    store.setDumplings(false);
                    store.setCheesericecake(false);
                    price = 30;
                }
            }
        });


        Rcheeserickcake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if (checked){
                    store.setporkbelly(false);
                    store.setDumplings(false);
                    store.setCheesericecake(true);
                    price = 17;
                }
            }
        });


        Rdumpling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if (checked){
                    store.setporkbelly(false);
                    store.setDumplings(true);
                    store.setCheesericecake(false);
                    price = 35;
                }
            }
        });
    }

    public void onClick (View v){
        int index = globalvariable.numOfOrder;
        int k = globalvariable.numOfac;
        TextView snack_amount = findViewById(R.id.snack_amount);
        Intent it = new Intent();
        switch (v.getId()){
            case R.id.snackminus:
                if (amount > 0) {
                    amount--;
                    store.setOrder_amount(amount);
                }
                else{
                    amount = 0;
                    store.setOrder_amount(amount);
                }
                snack_amount.setText(Integer.toString(amount));
                break;
            case R.id.snackplus:
                if (amount < 99) {
                    amount++;
                    store.setOrder_amount(amount);
                }
                else{
                    amount = 99;
                    store.setOrder_amount(amount);
                }
                snack_amount.setText(Integer.toString(amount));
                break;
            case R.id.snackshoppingcart:
                account storeac = globalvariable.registeredInfo[0];
                if(amount!=0 && (store.getcheesericecake() || store.getDumpling() || store.getporkbelly())){
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
                    globalvariable.numOfOrder++;
                    Toast.makeText(snackpage.this,"小計 $"+Integer.toString(amount*price)+", 已加入購物籃",Toast.LENGTH_LONG).show();
                }
            case R.id.snackhomepage:
                it.setClass(snackpage.this,MainActivity.class);
                startActivity(it);
                finish();
                break;

        }
    }
}