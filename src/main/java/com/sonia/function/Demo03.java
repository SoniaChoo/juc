package com.sonia.function;

import java.util.function.Consumer;

public class Demo03 {
    //消费型接口, 有输入， 但是没有输出
    public static void main(String[] args) {
//        Consumer consumer = new Consumer<String>() {
//            @Override
//            public void accept(String str) {
//                System.out.println(str);
//            }
//        };

        //lambda表达式写法
        Consumer consumer = (str)->{
            System.out.println(str);
        };
        consumer.accept("sonia");
    }
}
