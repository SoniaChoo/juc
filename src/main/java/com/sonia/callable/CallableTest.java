package com.sonia.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by sonia on 2020/7/28.
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        FutureTask task = new FutureTask(myThread);// 适配类
        new Thread(task).start();
        new Thread(task).start();// 结果会被缓存，效率高
        String s = (String) task.get(); //这个get 方法可能会产生阻塞！把他放到最后
        // 或者使用异步通信来处理！
        System.out.println(s);

    }
}

class MyThread implements Callable {

    @Override
    public String call() throws Exception {
        System.out.println("soniasonia");
        return "hello";
    }
}
