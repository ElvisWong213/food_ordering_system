package com.example.myapplication;

public class globalvariable {
    public static boolean login = false;
    public static int numOfOrder = 0;
    public static int numOfac = 0;
    public static final int maxnumoforder = 150;
    public static final int maxnumofac = 30;
    public static order[] ordering = new order[maxnumoforder];
    public static account[] ac = new account[maxnumofac];
    public static boolean firstOrder = true;
    public static account[] registeredInfo = new account[maxnumofac];

}