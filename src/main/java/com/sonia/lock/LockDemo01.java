package com.sonia.lock;

/**
 * Created by sonia on 2020/8/1.
 */
public class LockDemo01 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            phone.sms();
        },"A").start();

        new Thread(()->{
            phone.call();
        },"B").start();
    }

}

class Phone {
    public synchronized void sms() {
        System.out.println(Thread.currentThread().getName()+"发短信");
        call();
    }
    public synchronized void call(){
        System.out.println(Thread.currentThread().getName()+"call");
    }
}
