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
        System.out.println(str10.indexOf("e"));     // 字符串索引从0开始计算
        System.out.println(str10.indexOf("H", 2));  // 从索引2开始没有找到H，返回-1
        System.out.println(str10.lastIndexOf("!"));
        // 查找str10字符串中所有的字母o出现的位置

        // 替换
        String str11 = "xian jia yu";
        System.out.println(str11.replace("jia", "j"));
        System.out.println(str11.replaceAll(" ", "")); // regx:正则

    }
    @Test
    public void testFindForward(){
        String str12 = "Hello World, today is 2019-12-11. say hi to me!";
        int index = -1;
        int total = 0;
        do {
            int at = str12.indexOf("o", index+1);
            if (at == -1) break;
            System.out.println(String.format("第%d位是小写字母：o", at+1));
            index = at;
            total++;
        }while(true);
        System.out.println("该字符串中一共有" + total + "个小写字母o");

    }

    @Test
    public void testFindBack(){
        String str13 = "Hello World, today is 2019-12-11. say hi to me!";
        int index = str13.length();
        int total = 0;
        do {
            int at = str13.lastIndexOf("o", index-1);
            if (at == -1) break;
            System.out.println(String.format("第%d位是小写字母：o", at+1));
            index = at;
            total++;
        }while (true);
        System.out.println("该字符串中一共有" + total + "个小写字母o");
    }

    @Test
    public void testReplace(){
        String str14 = "xian jia yu";
        System.out.println(str14.replace("jia", "j"));
        System.out.println(str14.replaceAll(" ", "")); // regx:正则
    }

    @Test
    public void testUpperOrLower(){
        //大小写转换
        String str15 = "xian jia Yu";
        System.out.println(str15 + "大写转换后：" + str15.toUpperCase());
        System.out.println(str15 + "小写转换后：" + str15.toLowerCase());
    }

    @Test
    public void testTrim(){
        // 两边去空格
        String str16 = "   he l l o  ";
        System.out.println(str16.trim());
    }

    @Test
    public void testEmpty(){
        // 空串
        String str17 = ""; // 代表空的字符串
        System.out.println(str17);
        String str18 = null; // 代表存放的是空置，没有对齐进行初始化
        System.out.println(str18);
    }

    @Test
    public void testBuffer(){
        // StringBuffer
        StringBuffer sb = new StringBuffer(); // 默认容量大小：super(16); 继承AbstractStringBuilder
        StringBuffer sb2 = new StringBuffer(100); // 指定容量大小：100；
    }

    @Test
    public void testAppendOrLength(){
        // 拼接：+    如果JVM没有优化时，会产生多个中间(临时)变量，坑能会导致内存溢出
        String str1 = "Hello";
        str1 += ',';    // 单引号中只能写入字符，并且是单个字符
        str1 += "World";
        str1 += '!';
        System.out.println(String.format("拼接后的结果为：%s", str1));

        // 追加：append
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(',');
        sb.append("World");
        sb.append('!');
        // 在未执行toString方法前，JVM都是把这些字符串放在数组中，不会产生临时变量
        System.out.println(String.format("拼接后的结果为：%s", sb.toString()));
        // 打印sb的长度
        System.out.println(String.format("拼接后字符串的长度为为：%s", sb.length()));
        // 设置sb的长度为10
        sb.setLength(10);
        System.out.println(sb.toString()); // Hello,Worl
        // 设置sb的长度为20
        sb.setLength(20);
        System.out.println(sb.toString()); //Hello,Worl          10个空格
    }

    @Test
    public void testStringOptimize(){
        // JVM对字符串的优化，下面这种拼接的方，JVM会对其优化，6优化后结果为testStringOptimize2()方法中的结果
        // 第一种优化  +
        String str1 = "Hello" + ",World!";
        System.out.println(str1);

        // 第二种优化  变量+
        String str2 = str1 + "Sya Hi.";
        System.out.println(str2);

        StringBuilder sb = new StringBuilder();
        sb.append(str1);
        sb.append("Say Hi.");
        System.out.println(sb.toString());

        // 第三种优化  循环


    }
    /*
    对testStringOptimize()和testStringOptimize2()方法进行反编译
    反编译命令：javap -c ./target/test-classes/com/zeroten/string/StringTest.class
    public void testStringOptimize();
    Code:
       0: ldc           #103                // String Hello,World!
       2: astore_1
       3: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
       6: aload_1
       7: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      10: return

    public void testStringOptimize2();
    Code:
       0: ldc           #103                // String Hello,World!
       2: astore_1
       3: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
       6: aload_1
       7: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      10: return

     */


    @Test
    public void testStringOptimize2(){
        // JVM对字符串的优化
        String str2 = "Hello,World!";
        System.out.println(str2);
    }

    @Test
    public void testStringOptimize3(){
        // 第三种优化  循环
        // 查看拼接1-50000需要多长时间，优化前
        /*
          一般写法
         */
        long start = System.currentTimeMillis();   // 查看当前时间毫秒数
        String str = "";
        for (int n = 0; n < 20000; n++){
            str += n;
        }
        System.out.println(str.length());
        System.out.println(String.format("优化前耗时:%d ms", System.currentTimeMillis() - start));


        /*
            JVM虚拟机优化后的
         */
        start = System.currentTimeMillis();   // 查看当前时间毫秒数
        str = "";
        for (int n = 0; n < 20000; n++){
            /*
              虽然节省了部分时间和中间变量，但是该StringBuilder实在for循环内部，每循环一次都会创建一次对象
             */
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(n);
            str = sb.toString();
        }
        System.out.println(str.length());
        System.out.println(String.format("优化后耗时:%d ms", System.currentTimeMillis() - start));

        /*
            自己写：将StingBuilder放在循环外
         */
        start = System.currentTimeMillis();   // 查看当前时间毫秒数
        str = "";
        StringBuilder sb2 = new StringBuilder();
        for (int n = 0; n < 20000; n++){
            sb2.append(n);
        }
        str = sb2.toString();
        System.out.println(str.length());
        System.out.println(String.format("自己写耗时:%d ms", System.currentTimeMillis() - start));

    }

}
