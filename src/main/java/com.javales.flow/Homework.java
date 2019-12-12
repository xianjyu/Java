package com.javales.flow;

public class Homework {
    public static boolean isPalindromicNum(int x){
        /*
            直观上来看待回文数的话，就感觉像是将数字进行对折后看能否一一对应。
            所以这个解法的操作就是 取出后半段数字进行翻转。
            这里需要注意的一个点就是由于回文数的位数可奇可偶，所以当它的长度是偶数时，它对折过来应该是相等的；当它的长度是奇数时，那么它对折过来后，有一个的长度需要去掉一位数（除以 10 并取整）。
            具体做法如下：
                每次进行取余操作 （ %10），取出最低的数字：y = x % 10
                将最低的数字加到取出数的末尾：revertNum = revertNum * 10 + y
                每取一个最低位数字，x 都要自除以 10
                判断 x 是不是小于 revertNum ，当它小于的时候，说明数字已经对半或者过半了
                最后，判断奇偶数情况：如果是偶数的话，revertNum 和 x 相等；如果是奇数的话，最中间的数字就在revertNum 的最低位上，将它除以 10 以后应该和 x 相等。
         */
        if (x < 0 || (x != 0 && x %10 == 0)) return false;
        int num = 0;
        while(x > 0){  // 直到x<0退出循环
            num = num*10 + num%10;
            x/=10;  // 当x>0时，每次循环都执行x=x/10，直到x<0
        }
        return x == num || x == num/10; // 两种情况，x可能是奇或者偶数
    }


    public static void main(String[] args) {
        isPalindromicNum(12);
    }

}



