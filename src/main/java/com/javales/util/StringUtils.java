package com.javales.util;

public class StringUtils {

    public static String trimAll(String str){

        // 对字符串进去去空格，首先要知道的对象是字符串
        StringBuffer sb = new StringBuffer();
        // 对传进来的字符串进行for循环，然后进行判断和操作
        for (int index = 0; index < str.length(); index++){
            // 获取字符串的某个字符：str.charAt(index)方法
            if (str.charAt(index) == ' '){
                // 在循环过程中如果字符等于空，执行continue：不执行本次循环，跳转到循环开始的地方继续执行下一次循环
                continue;
            }
            sb.append(str.charAt(index));
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static String trimAllChar(String str){
        // 因为我们都知道String的底层是通过char来实现的，所以可以先把str取出来
        char[] ch = str.toCharArray();

        StringBuffer sb = new StringBuffer();

        for (int index = 0; index < ch.length; index++){
            if (ch[index] == ' ') continue;
            sb.append(ch[index]);
        }
        return sb.toString();
    }


    public static String reverseStr(String str) {
        StringBuffer sb = new StringBuffer();
        char[] ch = str.toCharArray();
        for (int index=ch.length-1; index >= 0; index--){
            sb.append(ch[index]);
        }
        return sb.toString();
    }
}
