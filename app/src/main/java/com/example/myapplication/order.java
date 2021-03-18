package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class order{
    private int price;
    private int order_amount;
    private String typeOfNoodle;
    private boolean porkbelly, cheesericecake, dumplings, ramune, greentea;
    order(int order_amount, String typeOfNoodle, int price, boolean porkbelly, boolean cheeserocecake, boolean dumplings, boolean ramune, boolean greentea){
        this.order_amount = order_amount;
        this.typeOfNoodle = typeOfNoodle;
        this.porkbelly = porkbelly;
        this.cheesericecake = cheeserocecake;
        this.dumplings = dumplings;
        this.ramune = ramune;
        this.greentea = greentea;
        this.price = price;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int p){
        price = p;
    }
    public  int getOrder_amount() {
        return order_amount;
    }
    public  void setOrder_amount(int o){
        this.order_amount = o;
    }
    public String getTypeOfNoodle(){
        return typeOfNoodle;
    }
    public void setTypeOfNoodle(String type){
        typeOfNoodle = type;
    }
    public boolean getporkbelly(){
        return porkbelly;
    }
    public void setporkbelly(boolean pork){
        porkbelly = pork;
    }
    public boolean getcheesericecake(){
        return cheesericecake;
    }
    public void setCheesericecake(boolean cheese){
        cheesericecake = cheese;
    }
    public boolean getDumpling(){
        return dumplings;
    }
    public void setDumplings(boolean dumpling){
        dumplings = dumpling;
    }
    public boolean getgreentea(){
        return greentea;
    }
    public void setGreentea(boolean tea){
        greentea = tea;
    }
    public boolean getramune(){
        return ramune;
    }
    public  void setRamune(boolean Ramune){
        ramune = Ramune;
    }

}