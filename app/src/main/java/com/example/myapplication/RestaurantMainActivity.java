package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RestaurantMainActivity extends AppCompatActivity{

    private ListView lvMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_main);

        lvMenu = findViewById(R.id.Menu);

//        View header = (View)getLayoutInflater().inflate(R.layout.headerView,null);
//        lvMenu.addHeaderView(header);

        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < globalvariable.numOfac; i++) {
            arrayList.add(globalvariable.ac[i].getPhoneno());
            System.out.println(globalvariable.ac[i].getLoginname());
        }



        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList);

        lvMenu.setAdapter(arrayAdapter);
        lvMenu.setOnItemClickListener(onClickListView);
    }

    private AdapterView.OnItemClickListener onClickListView = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent it = new Intent();
            if(position==0)
                it.setClass(RestaurantMainActivity.this,LoginActivity.class);
            if(position==1)
                it.setClass(RestaurantMainActivity.this,MainActivity.class);
            startActivity(it);
            finish();
        }
    };

}