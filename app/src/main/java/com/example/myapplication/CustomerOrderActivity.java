package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CustomerOrderActivity extends AppCompatActivity {

    private static int listIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_order);
    }

    public static void setListIndex(int input) {
        listIndex = input;
    }
}