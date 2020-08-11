package com.sonia.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CASDemo {
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference(2,2);

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"版本号" + atomicStampedReference.getStamp());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(2, 3, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName()+"版本号" + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(3, 2, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName()+"版本号" + atomicStampedReference.getStamp());
        },"A").start();

        new Thread(()->{
            Integer stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"版本号" + atomicStampedReference.getStamp());
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(2,6,atomicStampedReference.getStamp(), atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"版本号" + atomicStampedReference.getStamp());
        },"B").start();
    }
}
