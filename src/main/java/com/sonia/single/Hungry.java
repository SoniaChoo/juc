package com.sonia.single;

public class Hungry {
    private final static Hungry hungry = new Hungry();
    private Hungry(){}
    public static Hungry getInstance(){
        return Hungry.hungry;
    }

    public static void main(String[] args) {
        System.out.println(Hungry.getInstance());
        System.out.println(Hungry.getInstance());
    }
}
