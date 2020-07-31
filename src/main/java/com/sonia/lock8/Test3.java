package com.sonia.lock8;

import java.util.concurrent.TimeUnit;

/**
 * Created by sonia on 2020/7/28.
 */
// 5、增加两个静态的同步方法，只有一个对象，先打印 发短信？打电话？
// 6、两个对象！增加两个静态的同步方法， 先打印 发短信？打电话？
public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        Data3 data = new Data3();
        Data3 data3 = new Data3();
        new Thread(()->{
            try {
                data.sendMsg();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            data3.call();
        }).start();
    }
}

class Data3 {
    public  static synchronized void sendMsg() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("+++++++++++++++++++++++发送短信");
    }

    public static synchronized void call() {
        System.out.println("call");
    }
}
