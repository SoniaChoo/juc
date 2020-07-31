package com.sonia.function;

import java.util.function.Function;

public class Demo01 {
    public static void main(String[] args) {
        //函数型接口
//        Function<String,String> function = new Function<String, String>() {
//            public String apply(String s) {
//                return s;
//            }
//        };
        //lambda写法
        Function function = (str)->{
            return str;
        };
        System.out.println(function.apply("sonia"));
    }
}
