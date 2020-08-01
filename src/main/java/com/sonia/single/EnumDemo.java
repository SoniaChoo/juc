package com.sonia.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by sonia on 2020/8/1.
 */
public enum EnumDemo {
    INSTANCE;
    public  static EnumDemo getInstance() {
        return INSTANCE;
    }
}

class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumDemo instance1 = EnumDemo.getInstance();
        Constructor<EnumDemo> declaredConstructor = EnumDemo.class.getDeclaredConstructor(String.class,int.class);
        declaredConstructor.setAccessible(true);
        EnumDemo instance2 = declaredConstructor.newInstance();
        System.out.println(instance1);
        System.out.println(instance2);
    }
}
