package com.sonia.unsafeDemo;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by sonia on 2020/7/28.
 */
public class ListTest {
    public static void main(String[] args) {
        //List<Integer> list = new ArrayList<Integer>();
        // 第一种解决办法: 现在不用了  List<Integer> list =  new Vector<Integer>();
       //  List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        List<Integer> list = new CopyOnWriteArrayList();

//        List<Integer> list =  new LinkedList<>();
 //       List<Integer> list = Collections.synchronizedList(new LinkedList<Integer>());
        for (int i = 0; i < 3; i++) {
            int temp = i;
            new Thread(()->{
                list.add(temp);
                System.out.println(list);
            },String.valueOf(temp)).start();
        }
    }
}

