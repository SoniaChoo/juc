package com.sonia.productAndConsume;

import com.sun.org.apache.xerces.internal.parsers.CachingParserPool;

//传统的生产者和消费者问题
public class pcDemo01 {
    public static void main(String[] args) {
        Resource resource = new Resource();
            new Thread(()->{
                for (int i = 0; i < 10; i++) {
                    try {
                        resource.product();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"A").start();

            new Thread(()->{
                for (int i = 0; i <10 ; i++) {
                    try {
                        resource.consume();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"B").start();

        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    resource.product();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    resource.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
        }



}


//资源类记忆理解口诀, 等待->业务->唤醒

class Resource {
    private int number = 0;

    //生产
    public synchronized void  product() throws InterruptedException {
        while (number != 0) {
            //等待
            this.wait();
        }
        number++;
        System.out.println("线程"+Thread.currentThread().getName()+"生产"+number+"个");
        this.notifyAll();
    }

    public  synchronized void consume() throws InterruptedException {

        //while要替换成if 避免发生虚假唤醒
        while (number == 0) {
            //等待
            this.wait();
            //不是在这里打印的!!!
            //System.out.println("线程"+Thread.currentThread().getName()+"======>消费"+number+"个");
        }
        number--;
        System.out.println("线程"+Thread.currentThread().getName()+"======>消费"+number+"个");
        this.notifyAll();
    }
}
