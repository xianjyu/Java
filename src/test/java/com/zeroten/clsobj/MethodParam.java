package com.zeroten.clsobj;

import org.testng.annotations.Test;

// 方法参数
public class MethodParam {

    /*
        一个方法不能修改一个基本数据类型的参数，
        也不能修改引用类型参数的指向，
        但是却可以修改引用类型参数指向对象的值。
     */
    public void changePrimitive(int num){   // 修改基本类型参数
        System.out.println(String.format("传入参数值为：%d", num));  // 10
        // 修改num
        System.out.println(String.format("修改后参数值为：%d", num));  // 10
    }

    public void changeReference(StringBuilder sb){  // 修改引用类型参数
        System.out.println(String.format("传入参数值为：%s", sb.toString()));  // 字符串
        sb.append("-追加");
        // 修改num
        System.out.println(String.format("修改后参数值为：%s", sb.toString()));  // 字符串-追加

        sb = new StringBuilder();
        sb.append("新字符串");
    }

    @Test
    public void testMethodParam(){
        int num = 10;
        changePrimitive(num);
        System.out.println("num = " + num);

        StringBuilder sb = new StringBuilder();
        sb.append("字符串");
        changeReference(sb);
        System.out.println("sb = " + sb.toString());
    }
}
