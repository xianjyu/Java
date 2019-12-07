package com.zeroten.homework;

import org.testng.annotations.Test;

public class practice20191203 {

    @Test
    public void testInteger(){
        Integer n1 = 127;
        Integer n2 = 127;
        Integer n3 = 128;
        Integer n4 = 128;
        System.out.println((n1 == n2) + "," + (n3 == n4));  // true & false
    }

    @Test
    public void testDouble(){
        Double d1 = 127d; // 127.0
        Double d2 = 127d; // 127.0
        Double d3 = 128d; // 128.0
        Double d4 = 128d; // 128.0
        System.out.println((d1 == d2) + "," + (d3 == d4));  // false & false
    }

    @Test
    public void testEquals(){
        Integer n1 = 127;
        Integer n2 = new Integer(127); // n2是对象
        System.out.println((n1 == n2) + "," + n1.equals(n2));  // false & true
    }

    @Test
    public void testMaxRide(){
        /*
            问：下面的程序执行时是否会报错
            答：不会，数值计算超出范围时程序不会报错，但是会返回一个错误的结果
         */
        int iMax = Integer.MAX_VALUE;
        int val = iMax * iMax;
        System.out.println(val);
    }

    @Test
    public void testFloat(){
        /*
            问：float f = 3.14;会报错吗，为什么？
            答：会报错，因为值3.14未加后缀f，所有默认是double类型，float类型级别小于double类型，所有会报错
         */
        //float f = 3.14;
    }

    @Test
    public void testReturn(){
        /*
           问：3*0.1是否等于0.3
           答：3*0.1=0.30000000000000004
         */
        System.out.println(3*0.1);
    }


}
