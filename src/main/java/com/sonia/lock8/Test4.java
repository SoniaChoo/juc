package com.sonia.lock8;

import java.util.concurrent.TimeUnit;

/**
 * Created by sonia on 2020/7/28.
 */
//7.1个静态的同步方法，1个普通的同步方法 ，一个对象，先打印 发短信？打电话:打电话
// 8.1个静态的同步方法，1个普通的同步方法 ，两个对象，先打印 发短信？打电话:打电话
public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        Data4 data = new Data4();

        new Thread(()->{
            try {
                data.sendMsg();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            try {
                data.call();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class Data4 {
    public  static synchronized void sendMsg() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("+++++++++++++++++++++++发送短信");
    }

    public  synchronized void call() throws InterruptedException {
        System.out.println("call");
    }
}
