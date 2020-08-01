package com.sonia.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by sonia on 2020/8/1.
 */
public class LazyDemo2 {

    private LazyDemo2(){
        synchronized (LazyDemo2.class) {
            if (lazyDemo3 != null) {
                throw new RuntimeException("请不要用反射创建对象");
            }
        }
    };
    private volatile static LazyDemo2 lazyDemo3;
    public static LazyDemo2 getInstance() {
        if (lazyDemo3 == null) {
            synchronized (LazyDemo2.class) {
                if (lazyDemo3 == null) {
                    lazyDemo3 = new LazyDemo2();
                }
            }
        }
        return lazyDemo3;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        LazyDemo2 lazyDemo1 = LazyDemo2.getInstance();
        Constructor<LazyDemo2> declaredConstructor = LazyDemo2.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        LazyDemo2 lazyDemo2 = declaredConstructor.newInstance();
        System.out.println(lazyDemo1);
        System.out.println(lazyDemo2);
    }
}
/** 防止指令重排序
 * 1. 分配内存空间
 * 2、执行构造方法，初始化对象
 * 3、把这个对象指向这个空间
 *
 * 123
 * 132 A
 *     B // 此时lazyMan还没有完成构造
 */
