package com.sonia.lock8;

import java.util.concurrent.TimeUnit;

/**
 * Created by sonia on 2020/7/28.
 */

//锁的8个情况:3.增加了一个普通方法, 两个线程是先发短信还是hello: 先普通方法
//4.sendSmg延迟4秒, 两个对象, 两个同步方法,先发短信还是call: 1.call, 2.发短信(这个例子锁的是对象的实例)
public class Test2 {

    public static void main(String[] args) throws InterruptedException {
        Data2 data = new Data2();
        Data2 data2 = new Data2();
        new Thread(()->{
            try {
                data.sendMsg();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            data2.call();
        }).start();


//        new Thread(()->{
//            data.hello();
//        }).start();
    }
}

class Data2 {
    public  synchronized void sendMsg() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("+++++++++++++++++++++++发送短信");
    }

    public synchronized void call() {
        System.out.println("call");
    }

//    public void hello() {
//        System.out.println("hello");
//    }
}
