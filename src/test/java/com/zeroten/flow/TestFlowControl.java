package com.zeroten.flow;

import org.testng.annotations.Test;

import java.util.Random;

public class TestFlowControl {

    @Test
    public void testIfElse() {
        /**
         * 下面我们来做一个示例：给定一个年龄，然后判断该年龄属于儿童、青年、中年还是老年；年龄使用 int 类型，只支持整数。年龄段的划分规则如下：
         *  年龄范围 和描述
         *  0 ~ 6岁:儿童 ,7 ~ 17岁：少年 ,18 ~ 40岁：青年 ,41 ~ 59岁：中年,60及以上：老年
         *  if-else if -else if
         */
        int age = 7;
        if (age < 7){
            System.out.println("年龄" + age + "属于儿童");
        }else if (age < 17){
            System.out.println("年龄" + age + "属于少年");
        }else if (age <41){
            System.out.println("年龄" + age + "属于青年");
        }else if (age < 60){
            System.out.println("年龄" + age + "属于中年");
        }else if (age >= 60) {
            System.out.println("年龄" + age + "属于老年");
        }
    }

    @Test
    public void testWhile(){
        /**
         * 当 `Boolean-Exception` 的结果为真（true）时，一直执行 `statement`，直到 `Boolean-Exception` 的结果为假（false）。
         *
         *  练习：随机生成一个 `0 ～ 1000` 范围的整数
         *      如果不能被30整除，则打印出数字，   余数为0表示被整除
         *      如果能被30整除则退出循环。
         *      生成 `0 ~ 1000` 范围的整数使用语句 `int r = new Random().nextInt(1000)`。
         */
        boolean isContinue = true;
        int times = 0;
        while (isContinue) {
            int r = new Random().nextInt(1000);
            if (r%30 == 0) {
                isContinue = false;
                System.out.println(r + "能被30整除");
            }else {
                System.out.println(r + "不能被30整除");
                times++;
            }
        }
        System.out.println("本次循环一共有" + times + "个随机数不能被30整除！");
    }

    @Test
    public void testDoWhile(){
        /**
         *   do-while 和 while 的区别是 do-while 语句至少会执行一次，当表达式 `Boolean-Exception` 为假（false）时，退出循环，不在执行下一次。
         *  练习：和 `while` 部分的练习一样，随机生成一个 `0 ～ 1000` 范围的整数，
         *      如果不能被30整除，则打印出数字，
         *      如果能被30整除则退出循环。
         */
        boolean isContinue = true;
        int times = 0;
        do {
            int r = new Random().nextInt(1000);
            if (r%30 == 0) {
                isContinue = false;
                System.out.println(r + "能被30整除！");
            }else{
                System.out.println(r + "不能被30整除");
                times += 1;
            }
        }while(isContinue);
        System.out.println("本次循环一共有" + times + "个随机数不能被30整除！");
    }

    @Test
    public void testFor(){
        // 练习：打印 `0 ~ 100` 范围内的单数并计算范围内单数的总个数
        int total = 0;
        for(int n = 0; n <= 100; n++){
            if (n%2 != 0){
                System.out.println(n);
                ++total;
            }
        }
        System.out.println("1-100中一共有" + total + "个单数！");
    }

    @Test
    public void testSwitchCase(){
        /**
         * Integral-selector`（整数选择因子）是一个能产生整数值的表达式
         * 当产生的结果，和 case 后的值相等时，执行 case 后边的语句，直到 break 结束
         * 练习：假如你有一个机器人，你通过输入数字指令来指挥机器人
         *      比如输入 `1` 让机器人扫地，输入 `2` 让机器人打开灯。具体指令如下：
         *      1-扫地，2-开灯，3-关灯，4-播放音乐，5-关闭音乐，其他数字其他操作
         */
        int cmdN = 0;
        switch (cmdN){
            case 1: System.out.println("1-扫地"); break;
            case 2: System.out.println("2-开灯"); break;
            case 3: System.out.println("3-关灯"); break;
            case 4: System.out.println("4-播放音乐"); break;
            case 5: System.out.println("5-关闭音乐"); break;
            default: System.out.println("other number-不能识别的指令");
        }
        /**
         * 总结
         *  1、使用场景：当有多个选项时，如果使用if-else语法程序会显得冗长和笨拙的情况下使用switch-case
         *  2、当产生的数值和case相等时，会执行当前case下的代码，直至break退出
         *  3、当产生的数值与case都不等时，若有default就会执行default下的代码，没有就会执行后面的代码
         *  4、switch支持的数值类型有：int short byte char enum string，不支持Boolean类型
         *  if和switch的区别
         *  1、if是比较两个值得大小，switch是判断两个值是否相等
         *  2、当做等值是否相等的情况下，选择switch语句，在循环结构上会显得更加层次分明
         */
    }

    int getMaxNumRem7(int n1, int n2){
        // 从最大值往最小值取值，如果条件满足就return当前值，循环结束，取出的第一个值就是最大值，反之取最小值也是这个道理
        // 找出 `0 ~ n2` 范围内除以 n1 余 7 的最大的数，找到则返回该数，如果找不到则返回 -1。
        for (int n = n2; n >= 0; n--){
            if (n % n1 == 7){
                return n;
            }
        }
        return -1;
    }

    @Test
    public void testReturn(){
        /**
         *   return：中断当前循环，并直接返回
         *  练习2：编写一个方法 `int getMaxNumRem7(int n1, int n2)`
         *       找出 `0 ~ n2` 范围内除以 n1 余 7 的最大的数，找到则返回该数，如果找不到则返回 -1。
         */
        int r = getMaxNumRem7(10, 100);
        System.out.println(r);

    }

    @Test
    public void testBreak(){
        /**
         * break：跳出循环，继续执行该循环体后边的语句
         * 还是前边的练习，我们来改写一下
         * 随机生成一个 `0 ～ 1000` 范围的整数，如果不能被30整除，则打印出数字，如果能被30整除则退出循环。
         */
        // while循环的重构
        int times = 0;
        while(true){
            int r = new Random().nextInt(1000);
            if (r%30 == 0){
                System.out.println(r + "能被30整除！");
                break;  //如果r能被30整除，跳出while循环
            }else{
                System.out.println(r + "不能被30整除！");
                times += 1;
            }
        }
        System.out.println("本次循环一共有" + times + "个随机数不能被30整除!");
    }

    @Test
    public void testContinue(){
        /**
         * continue: 不再执行本次循环后边还未执行的语句，跳转到循环开始的地方进行下一次循环的执行
         * 找出 `0 ~ 100` 范围内能被7整除的数，并计算它们 累计相加 的结果
         */
        int total = 0;
        for (int i = 0; i <= 100; i++){
            if (i % 7 != 0){ // 如果i不能被7整除，继续下一次循环，直到i能被7整除，打印i
                continue;
            }
            System.out.println(i + "能被7整除");
            total += i;
        }
        System.out.println("0-100范围内能被7整除的数相加的和为：" + total);
    }

}
