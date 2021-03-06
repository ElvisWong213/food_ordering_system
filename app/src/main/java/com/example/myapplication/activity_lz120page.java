package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class lz120page extends AppCompatActivity implements View.OnClickListener {
    public int total = 0;
    private boolean checked = false, vegansausage = false, bff1 = false, bff2 = false;
    private TextView lz120amount;
    private RadioGroup lz120snack1RB, lz120snack2RB, lz120sausage;
    private RadioButton lz120vegan, lz120bff, lz120bff2, lz120beef, lz120pork, lz120sff, lz120sff2;
    private int amount = 0, price = 54;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lz120page);

        lz120amount = findViewById(R.id.lz120amount);
        ImageButton lz120minus = findViewById(R.id.lz120minus);
        lz120minus.setOnClickListener(this);
        ImageButton lz120plus = findViewById(R.id.lz120plus);
        lz120plus.setOnClickListener(this);
        ImageButton lz120shoppingcart = findViewById(R.id.lz120shoppingcart);
        lz120shoppingcart.setOnClickListener(this);
        lz120sausage = findViewById(R.id.lz120sausage);
        lz120snack1RB = findViewById(R.id.lz120snack1RB);
        lz120snack2RB = findViewById(R.id.lz120snack2RB);

        lz120beef = findViewById(R.id.lz120beef);
        lz120beef.setOnCheckedChangeListener(mOncheckedChangeListener);
        lz120vegan = findViewById(R.id.lz120vegan);
        lz120vegan.setOnCheckedChangeListener(mOncheckedChangeListener);
        lz120pork = findViewById(R.id.lz120pork);
        lz120pork.setOnCheckedChangeListener(mOncheckedChangeListener);


        lz120bff = findViewById(R.id.lz120bff);
        lz120bff.setOnCheckedChangeListener(mOncheckedChangeListener);
        lz120sff = findViewById(R.id.lz120sff);
        lz120sff.setOnCheckedChangeListener(mOncheckedChangeListener);


        lz120bff2 = findViewById(R.id.lz120bff2);
        lz120bff2.setOnCheckedChangeListener(mOncheckedChangeListener);
        lz120sff2 = findViewById(R.id.lz120sff2);
        lz120sff2.setOnCheckedChangeListener(mOncheckedChangeListener);
    }


    public void onClick(View v) {
        Intent it = new Intent();
        switch (v.getId()) {
            case R.id.lz120plus:
                if (amount < 100) {
                    amount++;
                    lz120amount.setText(amount + "");
                }
                break;
            case R.id.lz120minus:
                if (amount > 0) {
                    amount--;
                    lz120amount.setText(amount + "");
                }
                break;
            case R.id.lz120shoppingcart:
                if (amount > 0) {
                    if (vegansausage)
                        price+=18;
                    total += price * amount;
                    Toast.makeText(getApplicationContext(), "Total price: " + total, Toast.LENGTH_SHORT).show();
                }
                it.setClass(lz120page.this, MainActivity.class);
                startActivity(it);
                finish();
                break;
        }
    }

    private CompoundButton.OnCheckedChangeListener mOncheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton group, boolean checkedId) {
            if (checked) return;
            if (group.getId() == R.id.lz120sausage) {
                checked = true;
                lz120snack1RB.clearCheck();
                lz120snack2RB.clearCheck();
                checked = false;
            } else if (group.getId() == R.id.lz120snack1RB) {
                checked = true;
                lz120snack2RB.clearCheck();
                lz120sausage.clearCheck();
                checked = false;
            } else if (group.getId() == R.id.lz120snack2RB) {
                checked = true;
                lz120sausage.clearCheck();
                lz120snack1RB.clearCheck();
                checked = false;
            }
            switch (group.getId()){
                case R.id.lz120vegan:
                    vegansausage = true;
                    break;
                case R.id.lz120beef:
                case R.id.lz120pork:
                    vegansausage = false;
                    break;
                case R.id.lz120bff:
                    bff1=true;
                    break;
                case R.id.lz120sff:
                    bff1=false;
                    break;
                case R.id.lz120bff2:
                    bff2=true;
                    break;
                case R.id.lz120sff2:
                    bff2 = false;
                    break;
            }
        }
    };
}