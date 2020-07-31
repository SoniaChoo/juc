package com.sonia.demo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo02 {
    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                ticket.saleTicket();
            }, "A").start();

            new Thread(() -> {
                ticket.saleTicket();
            }, "B").start();
        }

    }
}

//资源类
class Ticket2 {
    //资源
    private int ticket = 50;

    //ReentrantLock 可以在构造函数中传入参数,确定是否是公平锁, 默认是非公平锁
    Lock lock = new ReentrantLock();

    public void saleTicket() {
        lock.lock();//加锁
        try {
            if (ticket > 0) {
                ticket--;
                System.out.println("当前操作的是线程"+Thread.currentThread().getName()+"还剩余车票"+ticket+"张");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//一定要在finally中显示释放锁,否则可能会造成死锁.
        }
    }

}
