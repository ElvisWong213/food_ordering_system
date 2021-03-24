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

        vLayout1 = new LinearLayout[6];
        hLayout = new LinearLayout[6];
        orderItem = new TextView[6];
        amount = new TextView[6];

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
            amount[index].setText("x" + String.valueOf(globalvariable.ordering[orderIndex].getOrder_amount()));

            hLayout[index] = new LinearLayout(this);
            hLayout[index].setPadding(0,30,0,30);
            hLayout[index].addView(vLayout1[index]);
            hLayout[index].addView(amount[index]);
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
}