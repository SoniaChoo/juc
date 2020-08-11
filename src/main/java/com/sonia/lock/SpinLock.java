package com.sonia.lock;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {
    AtomicReference atomicReference = new AtomicReference();

    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"加锁");
        while(!atomicReference.compareAndSet(null,thread));
    }

    public void myUnlock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"解锁");
        atomicReference.compareAndSet(thread,null);
    }
}
