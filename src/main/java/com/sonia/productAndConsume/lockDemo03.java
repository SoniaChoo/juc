package com.sonia.productAndConsume;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sonia on 2020/7/28.
 */

//lock方法可以实现synchronized的实现,但是lock中的condition可以精准唤醒线程
public class lockDemo03 {
    public static void main(String[] args) {
        Data3 data = new Data3();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                data.A();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                data.B();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                data.C();
            }
        },"C").start();
    }

}

class Data3 {
    private int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    public void A() {
        lock.lock();
        try {
            while(number != 0) {
                //等待
                condition1.await();
            }
            number = 1;
            System.out.println(Thread.currentThread().getName()+"===>"+number);
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void B() {
        lock.lock();
        try {
            while(number != 1) {
                //等待
                condition2.await();
            }
            number = 2;
            System.out.println(Thread.currentThread().getName()+"~~~~~"+number);
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void C() {
        lock.lock();
        try {
            while(number != 2) {
                //等待
                condition3.await();
            }
            number = 0;
            System.out.println(Thread.currentThread().getName()+"---------"+number);
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
