package com.sonia.add;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by sonia on 2020/7/29.
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, ()->{
            System.out.println("召唤tony");
        });

        for (int i = 0; i < 7; i++) {
            int temp = i;
            new Thread(()->{
                System.out.println("集齐sonia"+temp);
                try {
                    cyclicBarrier.await();//注意awit的位置
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
