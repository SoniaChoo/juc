package com.sonia.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sonia on 2020/8/1.
 */
public class LockDemo02 {
}

class phone2 {
    Lock lock = new ReentrantLock();
    public void sms(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"发短信");
            call();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void call(){
        System.out.println(Thread.currentThread().getName()+"call");
    }
}
