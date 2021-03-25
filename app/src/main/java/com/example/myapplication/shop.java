package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class shop extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        ImageButton shophomepage = findViewById(R.id.shophomepage);
        shophomepage.setOnClickListener(this);
        ImageButton facebook = findViewById(R.id.facebook);
        facebook.setOnClickListener(this);
        ImageButton openrice = findViewById(R.id.openrice);
        openrice.setOnClickListener(this);
        Button privacypage = findViewById(R.id.privacypage);
        privacypage.setOnClickListener(this);
        ImageButton mappage = findViewById(R.id.mappage);
        mappage.setOnClickListener(this);

    }
    public void onClick (View v){
        Intent it = new Intent();
        switch (v.getId()){
            case R.id.shophomepage:
                it.setClass(shop.this,MainActivity.class);
                startActivity(it);
                finish();
                break;
            case R.id.privacypage:
                it.setClass(shop.this,privacy.class);
                startActivity(it);
                finish();
                break;
            case R.id.facebook:
                String facebook_url = "https://www.facebook.com/tennoramenhk/";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(facebook_url)));
                break;
            case R.id.openrice:
                String openrice_url = "https://www.openrice.com/zh/hongkong/r-%E6%8B%89%E9%BA%B5%E5%A4%A9%E7%8E%8B-%E7%B4%85%E7%A3%A1-%E6%97%A5%E6%9C%AC%E8%8F%9C-%E6%8B%89%E9%BA%B5-r177334";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(openrice_url)));
                break;
            case R.id.mappage:
                it.setClass(shop.this,MapsActivity.class);
                startActivity(it);
                finish();
                break;
        }
    }
}