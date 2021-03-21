package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class personalInformation extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);
        ImageButton PIhomepage = findViewById(R.id.PIhomepage);
        PIhomepage.setOnClickListener(this);
        EditText inputAddress, inputCreditCard;
        inputAddress = findViewById(R.id.inputAddress);
        inputCreditCard = findViewById(R.id.inputCreditCardNo);
        Button transmit = findViewById(R.id.transmit);
        transmit.setOnClickListener(this);
        if(payment.recordAddress)
        {
            inputAddress.setHint("Address");
            inputAddress.setEnabled(true);

        }
        else
        {
            inputAddress.setText("不用填寫 (Not require to fill in)");
            inputAddress.setEnabled(false);
        }
        if (payment.recordCreditCard)
        {
            inputCreditCard.setHint("Credit Card Number");
            inputCreditCard.setEnabled(true);
        }
        else
        {
            inputCreditCard.setText("不用填寫 (Not require to fill in)");
            inputCreditCard.setEnabled(false);
        }
    }

    public void onClick(View v){
        Intent it = new Intent();
        EditText inputName, inputPhone, inputAddress, inputCreditCard;
        inputName = findViewById(R.id.inputName);
        inputPhone = findViewById(R.id.inputPhone);
        inputAddress = findViewById(R.id.inputAddress);
        inputCreditCard = findViewById(R.id.inputCreditCardNo);
        int k = globalvariable.numOfac;
        switch (v.getId()){
            case R.id.transmit:
                globalvariable.ac[k].setLoginname(inputName.toString());
                globalvariable.ac[k].setPhoneno(inputPhone.toString());
                globalvariable.ac[k].setAddress(inputAddress.toString());
                globalvariable.ac[k].setCreditCard(inputCreditCard.toString());
                globalvariable.numOfac++;
                globalvariable.firstOrder = true;
            case R.id.PIhomepage:
                it.setClass(personalInformation.this,MainActivity.class);
                startActivity(it);
                finish();
                break;

        }
    }
}