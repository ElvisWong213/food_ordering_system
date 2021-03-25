package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class account{
    private int startnum;
    private int endnum;
    private String loginname;
    private String password;
    private String address;
    private String phoneno;
    private String creditCard;
    private String CVC;
    private String validFrom;
    private Boolean tool;

    account(String loginname, String password, String address, String phoneno, String creditCard, String CVC, String validFrom){
        this.loginname = loginname;
        this.password = password;
        this.address = address;
        this.phoneno = phoneno;
        this.creditCard = creditCard;
        this.CVC = CVC;
        this.validFrom = validFrom;

    }
    public void setTool(Boolean input) {
        tool = input;
    }
    public Boolean getTool() {
        return tool;
    }
    public int getStartnum() {
        return startnum;
    }
    public void setStartnum(int startnum) {
        this.startnum = startnum;
    }
    public   int getEndnum() {
        return endnum;
    }
    public   void setEndnum(int endnum) {
        this.endnum = endnum;
    }

    public String getLoginname() {
        return loginname;
    }

    public   void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public   String getPassword() {
        return password;
    }

    public   void setPassword(String password) {
        this.password = password;
    }

    public   String getAddress() {
        return address;
    }

    public   void setAddress(String address) {
        this.address = address;
    }

    public   String getPhoneno() {
        return phoneno;
    }

    public   void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public void setCVC(String CVC) {
        this.CVC = CVC;
    }

    public String getCVC() {
        return CVC;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public String getValidFrom() {
        return validFrom;
    }
}