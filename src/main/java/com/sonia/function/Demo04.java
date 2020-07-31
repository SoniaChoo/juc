package com.sonia.function;

import java.util.function.Supplier;

public class Demo04 {
    //供给型接口,没有输入， 有返回值
    public static void main(String[] args) {
//        Supplier supplier = new Supplier<String>() {
//            @Override
//            public String get() {
//                System.out.println("hello");
//                return "sonia";
//            }
//        };

        //lambda表达式写法
        Supplier supplier = ()->{
            System.out.println("hello");
            return "sonia";
        };
        System.out.println(supplier.get());
    }
}
