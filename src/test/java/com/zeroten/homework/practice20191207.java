package com.zeroten.homework;

import org.testng.annotations.Test;

public class practice20191207 {

    @Test
    public void testAddSelf(){
        int n1 = 1; // 1
        n1 = ++n1;  // ++ 在前先运算后赋值 1+1=2 n1=2
        System.out.println(n1);  // 2

        int n2 = 1; // 1
        n2 = n2++;  // ++ 在后先赋值后运算 n2=1
        System.out.println(n2);     // 1
    }

    @Test
    public void testSubtractSelf(){
        int n3 = 1; // 1
        n3 = --n3;  // -- 在前先运算后赋值，0
        System.out.println(n3);  // 0

        int n4 = 1; // 1
        n4 = n4--;  // -- 在后先赋值后运算，1
        System.out.println(n4);  // 1

    }

    @Test
    public void testSwitchCase(){
        /*
            当代码运行到case=3时，执行代码块语句，但是没有break，会把case=3以及后面的语句都会执行
            执行结果应该为：3 4 5 0，default中也会执行的
         */
        int n = 3;
        switch (n) {
            case 1: System.out.println(1); break;
            case 2: System.out.println(2); break;
            case 3: System.out.println(3);
            case 4: System.out.println(4);
            case 5: System.out.println(5);
            default: System.out.println(0);
        }
    }

    @Test
    public void testFor(){
        /*
            a = (a++)
            第一步：把 a 存储临时变量 tmp
            第二步：把 a = a +1
            第三步：把 tmp 返回
            第四步：把返回的 tmp 赋值给 a
            所以 a 又变成 a 了
         */
        int a = 1;
        for (int i = 1; i < 3; i++) {
            /*
                a++：++ 在后，先赋值后运算，此时a等于1，虽然a++后，a的值+1了
                但是通过a = (a++)这样赋值后，a又变成了a
                所有a的值一直为1
             */
            a = (a++);  // a = a++;
        }
    }
}
