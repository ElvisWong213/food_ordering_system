package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantMainActivity extends AppCompatActivity {

    ListView lvMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_main);

        lvMenu = findViewById(R.id.Menu);

//        View header = (View)getLayoutInflater().inflate(R.layout.headerView,null);
//        lvMenu.addHeaderView(header);

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Hi");
        arrayList.add("bye");

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList);

        lvMenu.setAdapter(arrayAdapter);
    }
}