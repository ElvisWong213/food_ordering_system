package com.example.myapplication;

public class order {
    private static int price;
    private static int order_amount;
    private static String typeOfNoodle;
    private static boolean porkbelly, cheesericecake, dumplings, ramune, greentea;
    order(int o, String type, int p, boolean pork, boolean cheese, boolean dumpling, boolean Ramune, boolean tea){
        order_amount = o;
        typeOfNoodle = type;
        porkbelly = pork;
        cheesericecake = cheese;
        dumplings = dumpling;
        ramune = Ramune;
        greentea = tea;
        price = p;
    }
    public static int getPrice(){
        return price;
    }
    public static void setPrice(int p){
        price = p;
    }
    public static int getOrder_amount() {
        return order_amount;
    }
    public static void setOrder_amount(int o){
        order_amount = o;
    }
    public static String getTypeOfNoodle(){
        return typeOfNoodle;
    }
    public static void setTypeOfNoodle(String type){
        typeOfNoodle = type;
    }
    public static boolean getporkbelly(){
        return porkbelly;
    }
    public static void setporkbelly(boolean pork){
        porkbelly = pork;
    }
    public static boolean getcheesericecake(){
        return cheesericecake;
    }
    public static void setCheesericecake(boolean cheese){
        cheesericecake = cheese;
    }
    public static boolean getDumpling(){
        return dumplings;
    }
    public static void setDumplings(boolean dumpling){
        dumplings = dumpling;
    }
    public static boolean getgreentea(){
        return greentea;
    }
    public static void setGreentea(boolean tea){
        greentea = tea;
    }
    public static boolean getramune(){
        return ramune;
    }
    public static void setRamune(boolean Ramune){
        ramune = Ramune;
    }

}