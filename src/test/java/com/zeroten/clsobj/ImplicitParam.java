package com.zeroten.clsobj;

import org.testng.annotations.Test;

public class ImplicitParam {    // 隐式参数
    private int index;

    public ImplicitParam(){}

    public void print(String name){
        System.out.println(this.index + ". Hello," + name);  // this可以省略，如下
        System.out.println(index + ". Hello," + name);  // 如果没有使用this.前缀来访问时，Java会先看是否存在局部变量，否则再去看对象是否存在成员变量
    }

    @Test
    public void testImplicitParam(){
        ImplicitParam obj = new ImplicitParam();
        obj.print("yxj");
    }

    public void println(int... nums){
        if (nums == null) {
            System.out.println("nums is null.");
            return;
        }

        if (nums.length == 0){
            System.out.println("nums length is zero!");
        }

        for (int n = 0; n < nums.length; n++) {
            System.out.println(nums[n]);
        }
    }

    @Test
    public void testVarParam(){
        this.println();
        this.println(null);
        this.println(1);
        this.println(1,2,3,4,5);
    }


}
