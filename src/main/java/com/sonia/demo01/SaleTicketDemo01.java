package com.sonia.demo01;

import java.util.concurrent.Executor;

public class SaleTicketDemo01 {
    public static void main(String[] args) {
        //并发就是多个线程去操作同一个资源类，把资源类丢到线程中；\
        //runnable接口，函数式编程(参数) -> {代码}
        Ticket ticket = new Ticket();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                ticket.saleTicket();
            },"A").start();
            new Thread(() -> {
                ticket.saleTicket();
            },"B").start();
        }
    }
}


//class MyThread implements Runnable {
//    @Override
//    public void run() {
//
//    }
//}
//上面弄的这一段写法中，我们获取线程是通过实现runnable接口来实现的，其实这样耦合性是比较高的，
// 我们应该把线程当作一个单独的资源类，没有任何的附加操作，只有属性和方法

class Ticket {

    //属性和方法
    private int ticket = 50;

    //卖票的方法

    public synchronized void saleTicket() {
        if (ticket > 0) {
            ticket--;
            System.out.println("线程" + Thread.currentThread().getName() + "正在卖票 , 剩余车票" + ticket);
        }
    }
}

