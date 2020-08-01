package com.sonia.single;

/**
 * Created by sonia on 2020/8/1.
 */
public class Holder {
    private Holder(){};
    public static class Inner {
        private static final Holder holder = new Holder();
    }

    public static Holder getInstance(){
        return Inner.holder;
    }

    public static void main(String[] args) {
        System.out.println(Inner.holder);
    }
}
