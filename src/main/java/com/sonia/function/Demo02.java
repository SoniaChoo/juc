package com.sonia.function;

import java.util.function.Predicate;

public class Demo02 {
    //Predicate是一种断言型接口， 有输入，也有返回值， 但是返回值是布尔类型
    public static void main(String[] args) {
//        Predicate predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return false;
//            }
//        };

        //lambda表达式的写法
        Predicate predicate = (str) -> {
            return false;
        };
        System.out.println(predicate.test("sonia"));
    }
}
