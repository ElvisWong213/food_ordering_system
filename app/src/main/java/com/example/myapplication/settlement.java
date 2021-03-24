package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class settlement extends AppCompatActivity implements View.OnClickListener{
    boolean orderedNoodle = false;
    int amountnum;
    static boolean temp = false;

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
        Button changeorder = findViewById(R.id.changeorder);
        changeorder.setOnClickListener(this);
        TextView amount = findViewById(R.id.amount);
        int k = globalvariable.numOfac;
        if (globalvariable.firstOrder) {
            order_record.setText("還未添加任何食品到購物籃中");
            total.setText("");
            settle.setEnabled(false);
            settle.setBackgroundColor(getResources().getColor(R.color.gray));
            changeorder.setEnabled(false);
        }
        else {
            int endnum = globalvariable.numOfOrder-1;
            globalvariable.ac[k].setEndnum(endnum);
            changeorder.setEnabled(true);
            order_record.setText(showOrder(globalvariable.ordering, globalvariable.ac[k].getStartnum(), globalvariable.ac[k].getEndnum()));
            if(orderedNoodle) {
                settle.setEnabled(true);
                total.setText("總計： $" + calTotal(globalvariable.ordering, globalvariable.ac[k].getStartnum(), globalvariable.ac[k].getEndnum()));
                amount.setVisibility(View.VISIBLE);
                amount.setText("訂單數量： " + String.valueOf(amountnum));
            }
            else
            {
                settle.setEnabled(false);
                settle.setBackgroundColor(getResources().getColor(R.color.gray));
                total.setText("最低消費為一碗拉麵");
                temp = true;
            }
        }
    }
    public int calTotal(order[] orders, int startnum, int endnum){
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
            if (orders[i].getTypeOfNoodle().equals("white") ) {
                itemlist = itemlist.concat("白天王拉麵 ");
                orderedNoodle = true;
            }
            if (orders[i].getTypeOfNoodle().equals("red") ) {
                itemlist = itemlist.concat("赤天王拉麵 ");
                orderedNoodle = true;
            }
            if (orders[i].getTypeOfNoodle().equals("black")) {
                itemlist = itemlist.concat("黑天王拉麵 ");
                orderedNoodle = true;
            }
            if (orders[i].getTypeOfNoodle().equals("limited")) {
                itemlist = itemlist.concat("限定天王拉麵 ");
                orderedNoodle = true;
            }
            if (orders[i].getTypeOfNoodle().equals("null")) {
                itemlist = itemlist.concat("(單點) ");
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
            amountnum = amountnum + orders[i].getOrder_amount();
            itemlist = itemlist.concat("\n數量: " + orders[i].getOrder_amount());
            itemlist = itemlist.concat(" 總計：$" + orders[i].getPrice()+ "\n\n");
        }
        return itemlist;
    }
    public void onClick(View v) {
        Intent it = new Intent();
        switch (v.getId()){
            case R.id.changeorder:
                it.setClass(settlement.this,changeOrder.class);
                startActivity(it);
                finish();
                break;
            case R.id.vschomepage:
                it.setClass(settlement.this,MainActivity.class);
                startActivity(it);
                finish();
                break;
            case R.id.settle:
                it.setClass(settlement.this,payment.class);
                startActivity(it);
                finish();
                break;
        }

    }
    public static boolean getAmmountnum(){
        if (globalvariable.firstOrder) {
            return false;
        }
        return true;
    }
}