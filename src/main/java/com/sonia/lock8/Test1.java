package com.sonia.lock8;

import java.util.concurrent.TimeUnit;

/**
 * Created by sonia on 2020/7/28.
 */
//锁的8个情况:1.标准情况下, 两个线程是先发短信还是call: 1.发短信, 2.call
//2.sendSmg延迟4秒, 两个线程是先发短信还是call: 1.发短信, 2.call
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Data1 data = new Data1();
        new Thread(()->{
            try {
                data.sendMsg();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
                data.call();
        }).start();
    }
}

class Data1 {
    public  synchronized void sendMsg() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("+++++++++++++++++++++++发送短信");
    }

    public synchronized void call() {

        System.out.println("call");
    }
}
