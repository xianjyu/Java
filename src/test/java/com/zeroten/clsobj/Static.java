package com.zeroten.clsobj;

import org.testng.annotations.Test;

public class Static {
    private static final int MAX_COUNT = 6;     // MAX_COUNT表示Static类最多可创建实例的数量
    private static int count = 0;   // 静态域

    public Static() throws Exception {
        count++;
        if (count > MAX_COUNT){
            throw new Exception("Static类只能创建" + MAX_COUNT + "个对象！");
        }
    }

    public static void  printCount(){   // 静态方法
        System.out.println("总共有" + count + "个实例！");
    }

    @Test
    public void testStatic() throws Exception {
        new Static();
        Static s = new Static();
        new Static();
        new Static();
        new Static();

        s.printCount();         // 不推荐使用该种实例的对象访问静态方法
        Static.printCount();    // 类名访问静态方法

    }
}
