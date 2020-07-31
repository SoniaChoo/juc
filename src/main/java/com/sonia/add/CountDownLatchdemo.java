package com.sonia.add;

import java.util.concurrent.CountDownLatch;

/**
 * Created by sonia on 2020/7/28.
 */
public class CountDownLatchdemo {
    public static void main(String[] args) throws InterruptedException {
        //减法计数器
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"ok");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();//当这个减法计数器归零了,这个线程就被唤醒.
        System.out.println("close door");
    }
}
