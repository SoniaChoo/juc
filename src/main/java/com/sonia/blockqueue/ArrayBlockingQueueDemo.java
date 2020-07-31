package com.sonia.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by sonia on 2020/7/29.
 */
public class ArrayBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Object> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        //1.报异常
            System.out.println(arrayBlockingQueue.add("a"));
            arrayBlockingQueue.put("b");
            System.out.println(arrayBlockingQueue.offer("c"));
           System.out.println(arrayBlockingQueue.offer("d",3,TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.take());
        arrayBlockingQueue.poll(1,TimeUnit.SECONDS);
        //System.out.println(arrayBlockingQueue.remove());

        //2.不报异常
//        System.out.println(arrayBlockingQueue.offer("a"));
//        System.out.println(arrayBlockingQueue.offer("b"));
//        System.out.println(arrayBlockingQueue.offer("c"));
//        //System.out.println(arrayBlockingQueue.offer("d"));
//        System.out.println(arrayBlockingQueue.poll());
//        System.out.println(arrayBlockingQueue.poll());
//        System.out.println(arrayBlockingQueue.poll());
        //System.out.println(arrayBlockingQueue.poll());

        //阻塞
//        arrayBlockingQueue.put("a");
//        arrayBlockingQueue.put("b");
//        arrayBlockingQueue.put("c");
//        //arrayBlockingQueue.put("d");
//        //arrayBlockingQueue.put("d");
//        System.out.println(arrayBlockingQueue.take());
//        System.out.println(arrayBlockingQueue.take());
//        System.out.println(arrayBlockingQueue.take());
        //System.out.println(arrayBlockingQueue.take());

        //超时阻塞
//        System.out.println(arrayBlockingQueue.offer("a", 1, TimeUnit.SECONDS));
//        System.out.println(arrayBlockingQueue.offer("b", 1, TimeUnit.SECONDS));
//        System.out.println(arrayBlockingQueue.offer("c", 1, TimeUnit.SECONDS));
//        System.out.println(arrayBlockingQueue.offer("d", 1, TimeUnit.SECONDS));
//        System.out.println(arrayBlockingQueue.poll());
//        System.out.println(arrayBlockingQueue.poll());
//        System.out.println(arrayBlockingQueue.poll());
        //System.out.println(arrayBlockingQueue.poll());
    }
}
