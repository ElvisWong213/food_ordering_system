package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class personalInformation extends AppCompatActivity implements View.OnClickListener {
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);
        ImageButton PIhomepage = findViewById(R.id.PIhomepage);
        PIhomepage.setOnClickListener(this);
        EditText inputAddress, inputCreditCard, inputName, inputPhone, inputCVC, inputvalidfrom;
        inputAddress = findViewById(R.id.inputAddress);
        inputCreditCard = findViewById(R.id.inputCreditCardNo);
        Button transmit = findViewById(R.id.transmit);
        inputName=findViewById(R.id.inputName);
        inputPhone=findViewById(R.id.inputPhone);
        transmit.setOnClickListener(this);
        inputCVC = findViewById(R.id.inputCVC);
        inputvalidfrom = findViewById(R.id.inputvalidfrom);


        if(globalvariable.login)
        {
            inputName.setText(globalvariable.registeredInfo[0].getLoginname());
            inputPhone.setText(globalvariable.registeredInfo[0].getPhoneno());
            inputAddress.setText(globalvariable.registeredInfo[0].getAddress());
            inputCreditCard.setText(globalvariable.registeredInfo[0].getCreditCard());
            inputCVC.setText(globalvariable.registeredInfo[0].getCVC());
            inputvalidfrom.setText(globalvariable.registeredInfo[0].getValidFrom());
        }
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
            inputCVC.setText("Valid From");
            inputCVC.setEnabled(true);
            inputvalidfrom.setText("CVC");
            inputvalidfrom.setEnabled(true);
        }
        else
        {
            inputCreditCard.setText("不用填寫 (Not require to fill in)");
            inputCreditCard.setEnabled(false);
            inputCVC.setText("不用填寫 (Not require to fill in)");
            inputCVC.setEnabled(false);
            inputvalidfrom.setText("不用填寫 (Not require to fill in)");
            inputvalidfrom.setEnabled(false);
        }
    }

    public void onClick(View v){
        Intent it = new Intent();
        EditText inputName, inputPhone, inputAddress, inputCreditCard, inputCVC, inputvalidfrom;
        inputName = findViewById(R.id.inputName);
        inputPhone = findViewById(R.id.inputPhone);
        inputAddress = findViewById(R.id.inputAddress);
        inputCreditCard = findViewById(R.id.inputCreditCardNo);
        inputCVC = findViewById(R.id.inputCVC);
        inputvalidfrom = findViewById(R.id.inputvalidfrom);
        int k = globalvariable.numOfac;
        switch (v.getId()){
            case R.id.transmit:
                if(inputName.getText().toString().equals("") || inputPhone.getText().toString().length() != 8 ||
                        (inputAddress.getText().toString().equals("") && payment.recordAddress) ||
                        (inputCreditCard.getText().toString().length() != 16 && payment.recordCreditCard && inputCVC.getText().toString().length() != 3 && inputvalidfrom.getText().toString().equals("")))
                    Toast.makeText(personalInformation.this,"請確認輸入的資料正確無誤",Toast.LENGTH_LONG).show();
                else {
                    showQuitDialog();

                }
                break;
            case R.id.PIhomepage:
                it.setClass(personalInformation.this,MainActivity.class);
                payment.recordCreditCard = null;
                payment.recordAddress = null;
                startActivity(it);
                finish();
                break;

        }
    }
    private void showQuitDialog(){
        builder = new AlertDialog.Builder(this);
        builder.setMessage("當傳送訂單後，將不能更改或取消。");
        builder.setCancelable(false);
        Intent it = new Intent();
        EditText inputName, inputPhone, inputAddress, inputCreditCard, inputCVC, inputvalidfrom;
        inputName = findViewById(R.id.inputName);
        inputPhone = findViewById(R.id.inputPhone);
        inputAddress = findViewById(R.id.inputAddress);
        inputCreditCard = findViewById(R.id.inputCreditCardNo);
        inputCVC = findViewById(R.id.inputCVC);
        inputvalidfrom = findViewById(R.id.inputvalidfrom);
        int k = globalvariable.numOfac;

        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                globalvariable.ac[k].setLoginname(inputName.getText().toString());
                globalvariable.ac[k].setPhoneno(inputPhone.getText().toString());
                globalvariable.ac[k].setAddress(inputAddress.getText().toString());
                globalvariable.ac[k].setCreditCard(inputCreditCard.getText().toString());
                globalvariable.ac[k].setTool(payment.getToolCheck());
                payment.setToolCheck(false);
                globalvariable.numOfac++;
                globalvariable.firstOrder = true;
                it.setClass(personalInformation.this,MainActivity.class);
                startActivity(it);
                finish();
                Toast.makeText(getApplicationContext(),
                        "你的訂單已送出", Toast.LENGTH_LONG).show();
            }
        });

        builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alert = builder.create();
        alert.setTitle("是否確認傳送訂單 ?");
        alert.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent it = new Intent();
        it.setClass(personalInformation.this,payment.class);
        startActivity(it);
        finish();
    }
}