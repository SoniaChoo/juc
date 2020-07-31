package com.sonia.unsafeDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by sonia on 2020/7/28.
 */
public class MapTest {
    public static void main(String[] args) {
        //Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            int temp = i;
            new Thread(()->{
                map.put(Thread.currentThread().getName(), temp);
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }
}
