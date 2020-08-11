package com.sonia.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sonia on 2020/8/1.
 */
public class LockDemo02 {
    public static void main(String[] args) {
        Phone2 phone2 = new Phone2();
        Phone2 phone21 = new Phone2();
        new Thread(()->{
            phone2.sms();
        },"A").start();


        new Thread(()->{
            phone21.call();
        },"B").start();
    }


}

class Phone2 {
    Lock lock = new ReentrantLock();
    public void sms(){
        lock.lock();
        try {
            //System.out.println(Thread.currentThread().getName()+"发短信");
            TimeUnit.SECONDS.sleep(3);
            call();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void call(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"call");
            sms();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
