package com.sonia.deadlock;

import lombok.Synchronized;

/**
 * Created by sonia on 2020/8/11.
 */
//如果去查看是否真的发生了死锁，还是因为死循环,在window下面，可以使用jps -l查看是否有发生死锁的进程， 如果有， 可以用指令 jstack -l 进程号去查看死锁的具体信息。
class Holder implements Runnable {
    private String lockA;
    private String lockB;

    public Holder(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized(lockA) {
            System.out.println(Thread.currentThread().getName()+"拿到了"+lockA+"想要获取"+lockB);
            synchronized(lockB) {
                System.out.println(Thread.currentThread().getName()+"拿到了"+lockA+"想要获取"+lockB);
            }
        }
    }
}
public class Demo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new Holder(lockA, lockB)).start();
        new Thread(new Holder(lockB, lockA)).start();
    }
}
