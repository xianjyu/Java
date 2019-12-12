package com.zeroten.string;

import org.testng.annotations.Test;

public class StringTest {

    @Test
    public void testString(){
        /*
           使用双引号括起来的的字符串赋值时，JVM会先在字符串常量池中查找是否已存在该字符串
           1.如果存在，则返回该引用地址
           2.如果不存在，则在常量池中创建该字符串并返回其引用
         */
        String str1 = "hello"; // 一开始在常量池中是没有hello的，所以在常量池中会创建该字符串并返回对象str1
        String str2 = "hello"; // 因为上面已经创建了hello，所以str2去常量池查找，存在hello，所以会返回该引用地址给str2
        System.out.println("str1 = str2 为 " + (str1 == str2));

        String str3 = "hello" + "world"; // str3在常量池中创建并返回引用对象
        String str4 = str2 + "world"; // 在java中使用+或+=方式进行拼接且拼接内容中包含变量时，JVM都会在堆中分配一块新的内存用于存放该字符串并返回其引用
        System.out.println("str3 = str4 为 " + (str3 == str4));

        String str5 = new String("hello"); // 在java中使用new方式创建时，JVM都会在堆中分配一块新的内存用于存放该字符串并返回其引用
        String str6 = new String("hello"); // 同上，但注意的是，在堆中不会去查找是否有已存在的hello，而是直接分配一块新的内存
        System.out.println("str5 = str6 为 " + (str5 == str6));

        String str7 = str6.intern(); // intern()方法和str1类似，JVM会先在字符串常量池中查找是否已存在该字符串，如果存在，则返回该引用地址
        System.out.println("str1 = str7 为 " + (str1 == str7));

        String str8 = new String("hello").intern(); // 总结：使用了intern()方法，java都会先去常量池查找是否已存在
        System.out.println("str1 = str8 为 " + (str1 == str8));

        String str9 = "hello";
        str9 += "world";
        System.out.println("str3 = str9 为 " + (str3 == str9));
    }

    @Test
    public void testStringOperation(){
        /*
           字符串操作
           1.长度2.子串3.拼接4.格式化5.相等判断
           6.前后缀判断7.包含判断8.查找19.查找替换
           10.去空格11.大小写转换12.空串和Null串
         */
        // 长度
        String str = "HelloWorld";
        System.out.println(str + "字符串长度为：" + str.length());
        System.out.println(str + "字符串长度为：" + str.codePointCount(0, str.length()));

        // String str2 = "hello,\uD835\uDD5D\uD835\uDD60\uD835\uDD60\uD835\uDD5C";
        // System.out.println(str2 + "字符串长度为：" + str2.length()); // 14
        // System.out.println(str2 + "实际长度为：" + str2.codePointCount(0, str2.length())); // 10

        // 子串
        String str3 = "miss you";
        System.out.println(str3.substring(5));  // you
        System.out.println(str3.substring(3,6));    // s y

        // 拼接
        String str4 = "big" + "data";
        System.out.println(str4);
        String str5 = "java";
        str5 += str4;
        System.out.println(str5);

        // 格式化
        System.out.printf("hello, %s %n", "world");
        System.out.printf("⼤写a：%c %n", 'A');
        System.out.printf("100 > 50：%b %n", 100 > 50);
        System.out.printf("100除以2：%d %n", 100 / 2);
        System.out.printf("100的16进制数是：%x %n", 100);
        System.out.printf("100的8进制数是：%o %n", 100);
        System.out.printf("100元打8.5折扣是：%f 元%n", 100 * 0.85);
        System.out.printf("上述价格的16进制数是：%a %n", 50 * 0.85);
        System.out.printf("上⾯的折扣是%d%% %n", 85); // %转义
        String str6 = "java";
        System.out.println(String.format(str6));

        // 相等判断
        String str7 = "Hello";
        String str8 = "hello";
        System.out.println("str7 = str8 为：" + str7.equals(str8));
        System.out.println("str7 = str8 为：" + str7.equalsIgnoreCase(str8));

        String greeting = "hello";
        System.out.println(greeting == "hello");    // true
        System.out.println(greeting.substring(1,3) == "hel");   //false

        // 前后缀、包含判断
        String str9 = "JavaWeb";
        System.out.println(str9 + "是否以J开头：" + str9.startsWith("J"));
        System.out.println(str9 + "是否以b结束：" + str9.endsWith("b"));
        System.out.println(str9 + "是否包含aWe：" + str9.contains("aWe"));

        // 查找
        String str10 = "Hello World, today is 2019-12-11. say hi to me!";
        System.out.println(str10.indexOf("o"));
    }
}
