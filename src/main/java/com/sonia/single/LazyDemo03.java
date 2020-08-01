package com.sonia.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by sonia on 2020/8/1.
 * 红绿灯也是可以被破坏的
 */
public class LazyDemo03 {
    private volatile static LazyDemo03 lazyDemo03;

    private static boolean sonia = false;
    private LazyDemo03(){
        if (sonia == false) {
            sonia = true;
        }else{
            throw  new RuntimeException("请不要用反射创建对象");
        }
    };
    public static LazyDemo03 getInstance() {
        if (lazyDemo03 == null) {
            synchronized (LazyDemo03.class) {
                if (lazyDemo03 == null) {
                    lazyDemo03 = new LazyDemo03();
                }
            }
        }
        return lazyDemo03;
    }

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Field sonia = LazyDemo03.class.getDeclaredField("sonia");
        sonia.setAccessible(true);

        Constructor<LazyDemo03> declaredConstructor = LazyDemo03.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        LazyDemo03 lazyDemo03 = declaredConstructor.newInstance();

        sonia.set(lazyDemo03,false);
        LazyDemo03 lazyDemo031 = declaredConstructor.newInstance();
        System.out.println(lazyDemo03);
        System.out.println(lazyDemo031);
    }
}
