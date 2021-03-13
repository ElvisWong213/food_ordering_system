package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class settlement extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settlement);
        ImageButton vschomepage = findViewById(R.id.vschomepage);
        vschomepage.setOnClickListener(this);
        TextView order_record = findViewById(R.id.order_record);
        if (globalvariable.numOfOrder == 0)
            order_record.setText("還未添加任何食品到購物籃中");
    }
    public void onClick(View v) {
        Intent it = new Intent();
        switch (v.getId()){
            case R.id.vschomepage:
                it.setClass(settlement.this,MainActivity.class);
                startActivity(it);
                finish();
                break;
        }
    }
}