package com.zeroten.clsobj;

import org.testng.annotations.Test;

public class MethodOverloading {

    public void print(){
        System.out.println("print method!");
    }

    public void print(int num){}

    public void print(int num1, int num2){}

    public void print(String str1){}

    public void print(String str1, String str2){}

    @Test
    public void testMethodOverloading(){
        print();
        print(1);
        print("1");
        print("a", "b");
    }

}
