package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class changeOrder extends AppCompatActivity implements View.OnClickListener {
    int newAmount;
    int k = globalvariable.numOfac;
    int endnum = globalvariable.numOfOrder - 1;
    int nowOrderNo = globalvariable.ac[k].getStartnum();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_order);
        ImageButton changehomepage = findViewById(R.id.changehomepage);
        changehomepage.setOnClickListener(this);
        Button prev = findViewById(R.id.prev);
        prev.setOnClickListener(this);
        Button next = findViewById(R.id.next);
        next.setOnClickListener(this);
        prev.setEnabled(false);
        TextView showorder = findViewById(R.id.showorder);
        showorder.setText(showNowOrder(globalvariable.ordering));
        TextView change_amount = findViewById(R.id.change_amount);
        ImageButton changeplus = findViewById(R.id.changeplus);
        changeplus.setOnClickListener(this);
        ImageButton changeminus = findViewById(R.id.changeminus);
        changeminus.setOnClickListener(this);

    }

    public void onClick(View v) {
        Intent it = new Intent();
        Button prev = findViewById(R.id.prev);
        Button next = findViewById(R.id.next);
        TextView showorder = findViewById(R.id.showorder);
        switch (v.getId()) {
            case R.id.changehomepage:
                it.setClass(changeOrder.this, MainActivity.class);
                startActivity(it);
                finish();
                break;
            case R.id.prev:
                nowOrderNo--;
                prev.setEnabled(nowOrderNo != globalvariable.ac[k].getStartnum());
                next.setEnabled(nowOrderNo != endnum);
               showorder.setText(showNowOrder(globalvariable.ordering));
                break;
            case R.id.next:
                nowOrderNo++;
                next.setEnabled(nowOrderNo != endnum);
                prev.setEnabled(nowOrderNo != globalvariable.ac[k].getStartnum());
                showorder.setText(showNowOrder(globalvariable.ordering));
                break;
            case R.id.changeplus:
                break;
            case R.id.changeminus:
                break;
        }
    }

    private String showNowOrder(order[] orders) {
        String orderlist = "";
        if (orders[nowOrderNo].getTypeOfNoodle().equals("white")) {
            orderlist = orderlist.concat("白天王拉麵 ");
        }
        if (orders[nowOrderNo].getTypeOfNoodle().equals("red")) {
            orderlist = orderlist.concat("赤天王拉麵 ");
        }
        if (orders[nowOrderNo].getTypeOfNoodle().equals("black")) {
            orderlist = orderlist.concat("黑天王拉麵 ");
        }
        if (orders[nowOrderNo].getTypeOfNoodle().equals("limited")) {
            orderlist = orderlist.concat("限定天王拉麵 ");
        }
        if (orders[nowOrderNo].getTypeOfNoodle().equals("null")) {
            orderlist = orderlist.concat("(單點) ");
        }
        if (orders[nowOrderNo].getEgg()) {
            orderlist = orderlist.concat("味蛋(半隻) ");
        }
        if (orders[nowOrderNo].getCharsiu()) {
            orderlist = orderlist.concat("叉燒 ");
        }
        if (orders[nowOrderNo].getporkbelly()) {
            orderlist = orderlist.concat("豚角煮 ");
        }
        if (orders[nowOrderNo].getcheesericecake()) {
            orderlist = orderlist.concat("芝士年糕 ");
        }
        if (orders[nowOrderNo].getDumpling()) {
            orderlist = orderlist.concat("烤餃子(5隻) ");
        }
        if (orders[nowOrderNo].getramune()) {
            orderlist = orderlist.concat("波子汽水 ");
        }
        if (orders[nowOrderNo].getgreentea()) {
            orderlist = orderlist.concat("大分綠茶 ");

        }return orderlist;
    }
}