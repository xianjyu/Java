package com.zeroten.clsobj;

public class Person {
    // 下面这些定义的变量称作：域变量、也叫实例变量
    private String name;
    private int age;
    private Integer sex;
    private double height;
    private double weight;
    private static String count;    // 叫类变量、也可以叫域变量
    private String field;
    private static String classField;


    // 代码块：实例代码块，也可以叫做初始化代码块
    {
        count = "实例变量";
        System.out.println("在类里且方法之外用大括号括起来的一段代码");
    }

    // 静态代码块，也可以叫做静态初始化代码块
    static {
        classField = "类变量";
        System.out.println("在类里且方法之外用大括号括起来的被static修饰的一段代码");
    }

    // 方法
    public void walking(){}

    public void eat(){}

    // 实例变量
    int out_index = 0;
    public void sleep(){
        // 局部变量
        int inner_index = 1;
    }

    public void work(){}

    public void study(){}

    // 静态方法
    public static void print(){

    }

    // 构造方法，也叫构造器并且没有返回值：void
    public Person(){}

    // 内部类：在类中声明其他类
    class InnerClass{}


    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
    }
}

