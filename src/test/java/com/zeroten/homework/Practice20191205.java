package com.zeroten.homework;

import org.testng.annotations.Test;

public class Practice20191205 {

    @Test
    public void testGetVampireNum(){
        /**
         *  题目：写一个程序，找出四位数中所有的吸血鬼数字
         *  什么是吸血鬼数字
         *      1、位数为偶数的数字
         *      2、可以由一对数字相乘而得到，而这对数字各包含乘积的一半
         *      3、其中从最初的数字中选取的数字可以任意排序
         *      4、例如：1260=21*60 1827=21*87 2187=27*81
         */
//        int getVampireNum(){
//
//        }

        for (int i = 1000; i <= 9999; i++){
            for (int m = 0; m <= 99; m++){
                for (int n = 0; n <= 99; n++){
                    if (i == (m*n)){

                    }
                }
            }


        }
    }

    @Test
    public void testIsPalindromicNum(){
        /**
         *  题目：判断一个整数是否是回文数
         *  回文数
         *      回文数是指正序(从左到右)和倒序(从右到左)读都是一样的整数
         *  例如：101
         */

        int num = 121;


    }
}
