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
    private TextView orderItem[], snacks[], amount[], price[], totalPrice, tvCustomerName, tvPhoneNumber, tvAddress, tvTool;
    private String sAddress, sTool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_order);

        System.out.println(globalvariable.numOfOrder);
        tvCustomerName = findViewById(R.id.tvCustomerName);
        tvCustomerName.setText("顧客名稱: " + globalvariable.ac[listIndex].getLoginname());
        tvPhoneNumber = findViewById(R.id.tvPhoneNumber);
        tvPhoneNumber.setText("電話號碼: " + globalvariable.ac[listIndex].getPhoneno());
        tvAddress = findViewById(R.id.tvAddress);
        sAddress = "地址: ";
        if (globalvariable.ac[listIndex].getAddress().equals("不用填寫 (Not require to fill in)")) {
            sAddress += "外賣自取";
        }else{
            sAddress += globalvariable.ac[listIndex].getAddress();
        }
        tvAddress.setText(sAddress);

        tvTool = findViewById(R.id.tvTool);
        sTool = "餐具: ";
        if (globalvariable.ac[listIndex].getTool()) {
            sTool += "需要";
        }else{
            sTool += "不需要";
        }
        tvTool.setText(sTool);

        aLayout = findViewById(R.id.aLayout);

        vLayout1 = new LinearLayout[6];
        hLayout = new LinearLayout[6];
        orderItem = new TextView[6];
        amount = new TextView[6];
        price =  new TextView[6];

        totalPrice = new TextView(this);
        totalPrice.setTextSize(20);
        totalPrice.setGravity(Gravity.RIGHT);
        RestaurantMainActivity restaurantMainActivity = new RestaurantMainActivity();
        totalPrice.setText("總金額: $" + restaurantMainActivity.getTotalPrice(globalvariable.ac[listIndex].getStartnum(), globalvariable.ac[listIndex].getEndnum()));

        info(globalvariable.ac[listIndex].getStartnum(), globalvariable.ac[listIndex].getEndnum());

        aLayout.addView(totalPrice);
    }

    public static void setListIndex(int input) {
        listIndex = input;
    }

    public void info(int start, int end) {
        int index = 0;
        for (int orderIndex = start; (orderIndex <= end) && ((showNoodleName(orderIndex) != null) || (checkOtherItem(orderIndex))); orderIndex++) {

            if(showNoodleName(orderIndex) != null) {
                orderItem[index] = new TextView(this);
                orderItem[index].setTextSize(20);
                orderItem[index].setText(showNoodleName(orderIndex));
            }else{
                for (int i = 0; i < 7; i++) {
                    if (showOtherItem(orderIndex, i) != null) {
                        orderItem[index] = new TextView(this);
                        orderItem[index].setTextSize(20);
                        orderItem[index].setText(showOtherItem(orderIndex, i));
                        break;
                    }
                }
            }
            vLayout1[index] = new LinearLayout(this);
            vLayout1[index].setPadding(10,0,10,0);
            vLayout1[index].setOrientation(LinearLayout.VERTICAL);
            vLayout1[index].addView(orderItem[index]);

            if (showNoodleName(orderIndex) != null) {
                snacks = new TextView[7];
                for (int i = 0; i < 7; i++) {
                    if (showOtherItem(orderIndex, i) != null) {
                        snacks[index] = new TextView(this);
                        snacks[index].setText(showOtherItem(orderIndex, i));
                        vLayout1[index].addView(snacks[index]);
                        break;
                    }
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
            output = "白天王拉麵";
        }else if (globalvariable.ordering[index].getTypeOfNoodle().equals("red") ) {
            output = "赤天王拉麵";
        }else if (globalvariable.ordering[index].getTypeOfNoodle().equals("black")) {
            output = "黑天王拉麵";
        }else if (globalvariable.ordering[index].getTypeOfNoodle().equals("limited")) {
            output = "限定天王拉麵";
        }else if (globalvariable.ordering[index].getTypeOfNoodle().equals("null")) {
            output = null;
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
                break;
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