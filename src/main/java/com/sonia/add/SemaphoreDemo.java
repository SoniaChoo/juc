package com.sonia.add;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by sonia on 2020/7/29.
 */
public class SemaphoreDemo {
    public static void main(String[] args) throws InterruptedException{
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            int temp = i;
            new Thread(()->{
                try {
                    semaphore.acquire();//这个是写在try里面的,不是和lock一样卸载try外面的
                    System.out.println("线程"+temp+"抢到车位");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("线程"+temp+"释放车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();//这个和lock有点像,都是要放开
                }
            },String.valueOf(i)).start();
        }
    }
}
