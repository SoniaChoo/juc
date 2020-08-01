package com.sonia.tvolatile;

import java.util.concurrent.TimeUnit;

public class JMMDemo {
     static int number  = 0;
     static int temp = 2;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            int count = 0;
            while (number == 0) {
               // System.out.println(number);
                count++;
            }
            System.out.println("count="+count);
        }).start();

        TimeUnit.SECONDS.sleep(1);
        number = 1;
        System.out.println(number);
    }
}
