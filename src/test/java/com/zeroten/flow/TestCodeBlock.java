package com.zeroten.flow;

import org.testng.annotations.Test;

public class TestCodeBlock {

    @Test
    public void testBlockScope(){
        int n1 = 100;
        System.out.println(n1);
        {
            // int n1 = 101;   // 在代码块中是可以访问外层的变量n1，你在代码块中再定义n1就是重复了，所以会报错
            int n2 = 200;   // 块内定义的变量只能被只能被括起来的代码访问(读和写)
            System.out.println(n1);   // 100
            System.out.println(n2);   // 200
            {
                System.out.println(n2);  // 200，子代码块可以访问n2
            }
        }
        int n2 = 201;
        System.out.println(n2);  // 201，外层不能访问内存代码块定义的n2，所以此处在代码块外层访问变量n2就会报错
    }

}
