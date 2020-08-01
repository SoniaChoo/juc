package com.sonia.tvolatile;

import java.util.concurrent.atomic.AtomicInteger;

public class VDemo02 {
   // private volatile static int number = 0;
     static AtomicInteger number = new AtomicInteger();
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();;
                }
            }).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+" "+number);
    }

    public static void add() {
        //number++;
        number.getAndIncrement();
    }

}
