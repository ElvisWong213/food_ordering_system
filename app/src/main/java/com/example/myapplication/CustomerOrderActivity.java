package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomerOrderActivity extends AppCompatActivity {

    private static int listIndex;
    private LinearLayout vLayout1[], vLayout2[], aLayout, hLayout[];
    private TextView orderItem[], snacks[], amount[], tvCustomerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_order);

        tvCustomerName = findViewById(R.id.tvCustomerName);
        tvCustomerName.setText(globalvariable.ac[listIndex].getLoginname());

        aLayout = findViewById(R.id.aLayout);

        vLayout1 = new LinearLayout[4];
        hLayout = new LinearLayout[4];
        orderItem = new TextView[4];
        amount = new TextView[4];

        info(globalvariable.ac[listIndex].getStartnum(), globalvariable.ac[listIndex].getEndnum());
    }

    public static void setListIndex(int input) {
        listIndex = input;
    }

    public void info(int start, int end) {
        for (int orderIndex = start; (orderIndex <= end) && (showNoodleName(orderIndex) != null); orderIndex++) {
            orderItem[orderIndex] = new TextView(this);
            orderItem[orderIndex].setText(showNoodleName(orderIndex));
            vLayout1[orderIndex] = new LinearLayout(this);
            vLayout1[orderIndex].setOrientation(LinearLayout.VERTICAL);
            vLayout1[orderIndex].addView(orderItem[orderIndex]);

            snacks = new TextView[7];
            for (int i = 0; i < 7; i++) {
                if (showOtherItem(orderIndex, i) != null) {
                    snacks[i] = new TextView(this);
                    snacks[i].setText(showOtherItem(orderIndex, i));
                    vLayout1[orderIndex].addView(snacks[i]);
                }
            }
            amount[orderIndex] = new TextView(this);
            amount[orderIndex].setText(String.valueOf(globalvariable.ordering[orderIndex].getOrder_amount()));

            hLayout[orderIndex] = new LinearLayout(this);
            hLayout[orderIndex].addView(vLayout1[orderIndex]);
            hLayout[orderIndex].addView(amount[orderIndex]);
            aLayout.addView(hLayout[orderIndex]);
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
}