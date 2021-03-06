package com.sonia.single;

import javax.swing.*;

public class Lazyman {
    private Lazyman(){}
    private volatile static Lazyman lazyman;
    public  static Lazyman getInstance(){
        if (lazyman == null){
            synchronized (Lazyman.class) {
                if (lazyman == null) {
                   lazyman = new Lazyman();
                }
            }
        }
        return lazyman;
    }

    public static void main(String[] args) {

        Lazyman instance1 = Lazyman.getInstance();
        Lazyman instance2 = Lazyman.getInstance();

    }
}
