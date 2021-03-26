package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RestaurantMainActivity extends AppCompatActivity{

    private ListView lvDoMenu, lvDoneMenu;
    private account[] doList = new account[globalvariable.maxnumofac];
    private account[] doneList = new account[globalvariable.maxnumofac];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_main);

        lvDoMenu = findViewById(R.id.doMenu);
        lvDoneMenu = findViewById(R.id.doneMenu);

        ArrayList<String> doNameList = new ArrayList();
        ArrayList<String> doPriceList = new ArrayList();
        ArrayList<String> doTypeList = new ArrayList();

        ArrayList<String> doneNameList = new ArrayList();
        ArrayList<String> donePriceList = new ArrayList();
        ArrayList<String> doneTypeList = new ArrayList();

        int doListIndex = 0;
        int doneListIndex = 0;
        for (int i = 0; i < globalvariable.numOfac; i++) {
            if (!globalvariable.ac[i].getDone()) {
                doList[doListIndex] = globalvariable.ac[i];
                doListIndex++;
                doNameList.add(globalvariable.ac[i].getLoginname());
                doPriceList.add(String.valueOf(getTotalPrice(globalvariable.ac[i].getStartnum(), globalvariable.ac[i].getEndnum())));
                if (globalvariable.ac[i].getAddress().equals("不用填寫 (Not require to fill in)")) {
                    doTypeList.add("自取");
                }else{
                    doTypeList.add("外賣");
                }
            }else{
                doneList[doneListIndex] = globalvariable.ac[i];
                doneListIndex++;
                doneNameList.add(globalvariable.ac[i].getLoginname());
                donePriceList.add(String.valueOf(getTotalPrice(globalvariable.ac[i].getStartnum(), globalvariable.ac[i].getEndnum())));
                if (globalvariable.ac[i].getAddress().equals("不用填寫 (Not require to fill in)")) {
                    doneTypeList.add("自取");
                }else{
                    doneTypeList.add("外賣");
                }
            }

        }
        MyAdapter doAdapter = new MyAdapter(this, doNameList.toArray(new String[0]), doPriceList.toArray(new String[0]), doTypeList.toArray(new String[0]));
        lvDoMenu.setAdapter(doAdapter);
        lvDoMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent();
                it.setClass(RestaurantMainActivity.this,CustomerOrderActivity.class);
                CustomerOrderActivity.setListIndex(position);
                CustomerOrderActivity.setAcArray(doList);
                cleanArray();
                startActivity(it);
                finish();
            }

        });

        MyAdapter doneAdapter = new MyAdapter(this, doneNameList.toArray(new String[0]), donePriceList.toArray(new String[0]), doneTypeList.toArray(new String[0]));
        lvDoneMenu.setAdapter(doneAdapter);
        lvDoneMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent();
                it.setClass(RestaurantMainActivity.this,CustomerOrderActivity.class);
                CustomerOrderActivity.setListIndex(position);
                CustomerOrderActivity.setAcArray(doneList);
                cleanArray();
                startActivity(it);
                finish();
            }

        });

    }

    public void cleanArray() {
        for (int i = 0; i < globalvariable.maxnumofac; i++) {
            doneList[i] = null;
            doList[i] = null;
        }
    }

    public int getTotalPrice(int start, int end) {
        int total = 0;
        for (int i = start; i <= end; i++) {
            total += globalvariable.ordering[i].getPrice();
        }
        return total;
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String sTitle[];
        String sSubtitle[];
        String sType[];

        MyAdapter (Context c, String title[], String subtitle[], String type[]) {
            super(c, R.layout.row, R.id.tvTitle, title);
            this.context = c;
            this.sTitle = title;
            this.sSubtitle = subtitle;
            this.sType = type;
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            TextView tvTitle = row.findViewById(R.id.tvTitle);
            TextView tvSubtitle = row.findViewById(R.id.tvSubtitle);
            TextView tvType = row.findViewById(R.id.tvType);

            tvTitle.setText("顧客名稱: " + sTitle[position]);
            tvSubtitle.setText("消費金額: $" + sSubtitle[position]);
            tvType.setText(sType[position]);


            return row;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent it = new Intent();
        it.setClass(RestaurantMainActivity.this,LoginActivity.class);
        startActivity(it);
        finish();
    }

}