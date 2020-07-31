package com.sonia.unsafeDemo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by sonia on 2020/7/28.
 */
public class SetTest {
    public static void main(String[] args) {
//        Set set = new HashSet();
//        Set set = new CopyOnWriteArraySet();
        Set set = Collections.synchronizedSet(new HashSet<>());
        for (int i = 0; i < 10; i++) {
            int temp = i;
            new Thread(()->{
                set.add(temp);
                System.out.println(set);
            },String.valueOf(temp)).start();
        }
    }
}
