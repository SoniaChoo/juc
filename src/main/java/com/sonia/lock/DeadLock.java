package com.sonia.lock;

import java.util.concurrent.TimeUnit;

public class DeadLock {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new MyThread(lockA,lockB).start();
        new MyThread(lockB,lockA).start();
    }
}

class MyThread extends Thread {
    private String lockA;
    private String lockB;

    public MyThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    public void run(){
    synchronized (lockA) {
        System.out.println(Thread.currentThread().getName()+"拿到了"+lockA+"to get "+lockB);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lockB) {
            System.out.println(Thread.currentThread().getName()+"拿到了"+lockB);
        }
    }
    }

}
