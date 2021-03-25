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

    private ListView lvMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_main);

        lvMenu = findViewById(R.id.Menu);

        ArrayList<String> nameList = new ArrayList();
        ArrayList<String> priceList = new ArrayList();
        ArrayList<String> typeList = new ArrayList();

        for (int i = 0; i < globalvariable.numOfac; i++) {
            nameList.add(globalvariable.ac[i].getLoginname());
            priceList.add(String.valueOf(totalPrice(globalvariable.ac[i].getStartnum(), globalvariable.ac[i].getEndnum())));
            if (globalvariable.ac[i].getAddress().equals("不用填寫 (Not require to fill in)")) {
                typeList.add("自取");
            }else{
                typeList.add("外賣");
            }

        }
        MyAdapter adapter = new MyAdapter(this, nameList.toArray(new String[0]), priceList.toArray(new String[0]), typeList.toArray(new String[0]));
        lvMenu.setAdapter(adapter);
        lvMenu.setOnItemClickListener(onClickListView);

    }

    private String totalPrice(int start, int end) {
        int total = 0;
        for (int i = start; i <= end; i++) {
            total += globalvariable.ordering[i].getPrice();
        }
        return String.valueOf(total);
    }

    private AdapterView.OnItemClickListener onClickListView = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent it = new Intent();
            it.setClass(RestaurantMainActivity.this,CustomerOrderActivity.class);
            CustomerOrderActivity.setListIndex(position);
            startActivity(it);
            finish();
        }

    };

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
        it.setClass(RestaurantMainActivity.this,MainActivity.class);
        startActivity(it);
        finish();
    }

}