package com.sonia.readAndWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by sonia on 2020/7/29.
 */
public class readAndWriteDemo {
    public static void main(String[] args) {
        //MyCache myCache = new MyCache();
        MyCacheLock myCache = new MyCacheLock();
        for (int i = 0; i < 10; i++) {
            int temp = i;
            new Thread(()->{
                myCache.put(temp,temp);
            },String.valueOf(i)).start();
        }

        for (int i = 0; i < 10; i++) {
            int temp = i;
            new Thread(()->{
                myCache.get(temp);
            },String.valueOf(i)).start();
        }
    }

}

//自定义缓存 readwritelock

class MyCacheLock {
    private volatile Map map = new HashMap<Integer,Integer>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //写锁是独占锁
    public void put(Integer key, Integer value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"写入"+key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入ok");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    //读锁是共享锁
    public void get(Integer key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"读取"+key);
            Integer value = (Integer) map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取ok");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}

//自定义缓存(无锁)

class MyCache {
    private volatile Map map =  new HashMap<Integer,Integer>();

    //存,写
    public void put(Integer key, Integer value){
        System.out.println(Thread.currentThread().getName()+"写入"+key);
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"写入ok");
    }

    //读,取
    public void get(Integer key) {
        System.out.println(Thread.currentThread().getName()+"读取"+key);
        Integer value = (Integer) map.get(key);
        System.out.println(Thread.currentThread().getName()+"读取ok");
    }
}
