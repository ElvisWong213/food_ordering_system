package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class settlement extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settlement);
        ImageButton vschomepage = findViewById(R.id.vschomepage);
        vschomepage.setOnClickListener(this);
        TextView order_record = findViewById(R.id.order_record);
        TextView total = findViewById(R.id.total);
        Button settle = findViewById(R.id.settle);
        settle.setOnClickListener(this);
        int index = globalvariable.numOfOrder;
        int k = globalvariable.numOfac;
        int endnum = globalvariable.numOfOrder-1;;
        if (globalvariable.numOfOrder == 0) {
            order_record.setText("還未添加任何食品到購物籃中");
            total.setText("");
        }
        else {
            order_record.setText(showOrder(globalvariable.ordering, globalvariable.ac[k].getStartnum(), endnum));
            total.setText("總計： $"+calTotal(globalvariable.ordering, globalvariable.ac[k].getStartnum(), endnum));
        }
    }
    private int calTotal(order[] orders, int startnum, int endnum){
        int total = 0;
        for(int i = startnum; i <= endnum; i++)
        {
            total += orders[i].getPrice();
        }
        return total;
    }
    private String showOrder(order[] orders, int startnum,int endnum){
        String itemlist = "";
        for(int i = startnum; i <= endnum; i++) {
            if (orders[i].getTypeOfNoodle() == "white") {
                itemlist = itemlist.concat("白天王拉麵 ");
            }
            if (orders[i].getEgg()) {
                itemlist = itemlist.concat("味蛋(半隻) ");
            }
            if (orders[i].getCharsiu()) {
                itemlist = itemlist.concat("叉燒 ");
            }
            if (orders[i].getporkbelly()) {
                itemlist = itemlist.concat("豚角煮 ");
            }
            if (orders[i].getcheesericecake()) {
                itemlist = itemlist.concat("芝士年糕 ");
            }
            if (orders[i].getDumpling()) {
                itemlist = itemlist.concat("烤餃子(5隻) ");
            }
            if (orders[i].getramune()) {
                itemlist = itemlist.concat("波子汽水 ");
            }
            if (orders[i].getgreentea()) {
                itemlist = itemlist.concat("大分綠茶 ");
            }
            itemlist = itemlist.concat("X" + orders[i].getOrder_amount());
            itemlist = itemlist.concat(" 總計：$" + orders[i].getPrice()+"\n");
        }
        return itemlist;
    }
    public void onClick(View v) {
        Intent it = new Intent();
        switch (v.getId()){
            case R.id.vschomepage:
                it.setClass(settlement.this,MainActivity.class);
                startActivity(it);
                finish();
                break;
            case R.id.settle:
                globalvariable.numOfac++;
                globalvariable.firstOrder = true;
                break;
        }

    }
}