package com.sonia.productAndConsume;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class pcDemo02 {
    public static void main(String[] args) {
        Data data = new Data();
//        for (int i = 0; i < 10; i++) {
//            new Thread(()->{
//                data.product();
//            },"A").start();
//
//            new Thread(()->{
//                data.consume();
//            },"B").start();
//        }

        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                data.product();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.consume();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                data.product();
            }
        },"C").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.consume();
            }
        },"D").start();
    }
}


//纯粹的资源类, 只有属性和方法, 等待->业务->通知
class Data {
    //资源
    private int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void product() {
        lock.lock();
        try {
//            lock.lock(); 注意这个lock不要卸载try里面
            while (number != 0) {//超过2个线程的时候,这里要用while,不能用if
                //等待
                condition.await();;
            }
            //业务
            number++;
            System.out.println(Thread.currentThread().getName()+"生产====>"+number);
            //通知
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//主动释放锁
        }
    }

    public void consume() {
        lock.lock();
        try {
//            lock.lock();//注意这个lock要写在方法最前面
            while (number == 0) {
                //等待
                condition.await();
            }
            //业务
            number--;
            System.out.println(Thread.currentThread().getName()+"消费==========>"+number);
            //通知
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
