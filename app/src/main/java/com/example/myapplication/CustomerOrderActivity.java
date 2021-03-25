package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Constraints;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;

public class CustomerOrderActivity extends AppCompatActivity {

    private static int listIndex;
    private LinearLayout vLayout1[], aLayout, hLayout[];
    private TextView orderItem[], snacks[], amount[], price[], tvCustomerName, tvPhoneNumber, tvAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_order);

        tvCustomerName = findViewById(R.id.tvCustomerName);
        tvCustomerName.setText("顧客名稱: " + globalvariable.ac[listIndex].getLoginname());
        tvPhoneNumber = findViewById(R.id.tvPhoneNumber);
        tvPhoneNumber.setText("電話號碼: " + globalvariable.ac[listIndex].getPhoneno());
        tvAddress = findViewById(R.id.tvAddress);
        if (globalvariable.ac[listIndex].getAddress().equals("不用填寫 (Not require to fill in)")) {
            tvAddress.setText("地址: 外賣自取");
        }else{
            tvAddress.setText("地址: " + globalvariable.ac[listIndex].getAddress());
        }

        aLayout = findViewById(R.id.aLayout);

        vLayout1 = new LinearLayout[6];
        hLayout = new LinearLayout[6];
        orderItem = new TextView[6];
        amount = new TextView[6];
        price =  new TextView[6];

        info(globalvariable.ac[listIndex].getStartnum(), globalvariable.ac[listIndex].getEndnum());
    }

    public static void setListIndex(int input) {
        listIndex = input;
    }

    public void info(int start, int end) {
        int index = 0;
        for (int orderIndex = start; (orderIndex <= end) && ((showNoodleName(orderIndex) != null) || (checkOtherItem(orderIndex))); orderIndex++) {

            System.out.println(orderIndex);
            if(showNoodleName(orderIndex) != null) {
                orderItem[index] = new TextView(this);
                orderItem[index].setTextSize(20);
                orderItem[index].setText(showNoodleName(orderIndex));
            }else{
                for (int i = 0; i < 7; i++) {
                    if (showOtherItem(orderIndex, i) != null) {
                        orderItem[index] = new TextView(this);
                        orderItem[index].setText(showOtherItem(orderIndex, i));
                        System.out.println(showOtherItem(orderIndex, i));
                        break;
                    }
                }
            }
            vLayout1[index] = new LinearLayout(this);
            vLayout1[index].setPadding(10,0,10,0);
            vLayout1[index].setOrientation(LinearLayout.VERTICAL);
            vLayout1[index].addView(orderItem[orderIndex]);

            snacks = new TextView[7];
            for (int i = 0; i < 7; i++) {
                if (showOtherItem(orderIndex, i) != null) {
                    snacks[i] = new TextView(this);
                    snacks[i].setText(showOtherItem(orderIndex, i));
                    vLayout1[index].addView(snacks[i]);
                }
            }
            amount[index] = new TextView(this);
            amount[index].setTextSize(20);
            amount[index].setText(String.valueOf(globalvariable.ordering[orderIndex].getOrder_amount()) + "x");

            price[index] = new TextView(this);
            price[index].setTextSize(20);
            price[index].setText("$" + String.valueOf(globalvariable.ordering[orderIndex].getPrice()));

            hLayout[index] = new LinearLayout(this);
            hLayout[index].setPadding(0,30,0,30);
            hLayout[index].addView(amount[index]);
            hLayout[index].addView(vLayout1[index]);
            hLayout[index].addView(price[index]);
            aLayout.addView(hLayout[index]);
            index++;
        }

    }

    public String showNoodleName(int index) {
        String output = null;
        if (globalvariable.ordering[index].getTypeOfNoodle().equals("white") ) {
            output = "白天王拉麵 ";
        }
        if (globalvariable.ordering[index].getTypeOfNoodle().equals("red") ) {
            output = "赤天王拉麵 ";
        }
        if (globalvariable.ordering[index].getTypeOfNoodle().equals("black")) {
            output = "黑天王拉麵 ";
        }
        if (globalvariable.ordering[index].getTypeOfNoodle().equals("limited")) {
            output = "限定天王拉麵 ";
        }
        return output;
    }

    public String showOtherItem(int index, int i) {
        String output = null;
        if (globalvariable.ordering[index].getEgg() && i == 0) {
            output = "味蛋(半隻) ";
        }
        if (globalvariable.ordering[index].getCharsiu() && i == 1) {
            output = "叉燒 ";
        }
        if (globalvariable.ordering[index].getporkbelly() && i == 2) {
            output = "豚角煮 ";
        }
        if (globalvariable.ordering[index].getcheesericecake() && i == 3) {
            output = "芝士年糕 ";
        }
        if (globalvariable.ordering[index].getDumpling() && i == 4) {
            output = "烤餃子(5隻) ";
        }
        if (globalvariable.ordering[index].getramune() && i == 5) {
            output = "波子汽水 ";
        }
        if (globalvariable.ordering[index].getgreentea() && i == 6) {
            output = "大分綠茶 ";
        }
        return output;
    }

    public Boolean checkOtherItem(int orderIndex) {
        Boolean output = false;
        for (int i = 0; i < 7; i++) {
            if (showOtherItem(orderIndex, i) == null) {
                output = false;
            }else{
                output = true;
            }
        }
        return output;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent it = new Intent();
        it.setClass(CustomerOrderActivity.this,RestaurantMainActivity.class);
        startActivity(it);
        finish();
    }
}