package com.zeroten.array;

import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class ArrayTest {

    @Test
    public void testArrayStatement1(){
        /*
            内存地址：[I@2d3379b4
                [：代表数组
                I：代表int类型
                @：代表拼接符
                2d3379b4：对象地址
            [Ljava.lang.String;@30c15d8b
                [：代表数组
                L：代表  类型
                java.lang.String;：代表String在lang包下
                @：代表拼接符
                30c15d8b：对象地址
         */

        int[] arr1 = new int[3];
        String[] arrS1 = new String[3];

        System.out.println(arr1);   // [I@2d3379b4
        System.out.println(arrS1);  // [Ljava.lang.String;@30c15d8b

        System.out.println(Arrays.toString(arr1));      // [0, 0, 0]
        System.out.println(Arrays.toString(arrS1));     // [null, null, null]
    }

    @Test
    public void testArrayStatement2(){

        int[] arr = new int[] {1, 2, 3};
        String[] arrS = new String[]{"1", "2", "3"};

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arrS));
    }

    @Test
    public void testArrayStatement3(){

        int[] arr = { 1, 2, 3};
        String[] arrS = {"1", "2", "3"};

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arrS));
    }

    @Test
    public void testArrayTraversal(){
        /*
            ArrayTraversal：数组遍历
         */
        // for循环变量
        Integer[] arr = {1, 2, 3, 4, 5};
        for (int index = 0; index < arr.length; index++){
            System.out.println(String.format("下标：%d 存放的数值为：%d", index, arr[index]));
        }

        // for each
        int index = 0;
        for (int var : arr){
            System.out.println(String.format("第%d次取到的数值为%d", index, var));
            index++;
        }

        // Lambda表达式
        // Arrays.asList():将数组转换成集合
        Arrays.asList(arr).forEach(val -> System.out.println("值为：" + val));  // 在forEach中如果只有一条语句，不需要用大括号
        Arrays.asList(arr).forEach(val ->{
            System.out.println("值为：" + val);
            if (val % 2 == 0){
                System.out.println(" 它是偶数！");
            }else{
                System.out.println(" 它是奇数！");
            }
        });

    }

    @Test
    public void testArrayCopy(){
        Integer[] arr1 = {1, 2, 3, 4, 5};
        Integer[] arr2 = {6, 7, 8, 9, 10};

        // 1.拷⻉数组 arr1 的前 3 个元素
        Integer[] arr3 = new Integer[3];    // 本办法
        arr3[0] = arr1[0];
        arr3[1] = arr1[1];
        arr3[2] = arr1[2];
        System.out.println("arr3 = " + Arrays.toString(arr3));  // arr3 = [1, 2, 3]

        Integer[] arr4 =Arrays.copyOf(arr1, 3);     // 使用Arrays的工具类copyOf()
        System.out.println("arr4 = " + Arrays.toString(arr4));

        // 拷⻉数组 arr1 的后 3 个元素
        Integer[] arr5 = Arrays.copyOfRange(arr1, arr1.length-3, arr1.length);
        System.out.println("arr5 = " + Arrays.toString(arr5));

        // 2.拷⻉数组 arr1 的第 1 位到第 3 位的元素（不包括第 3 位）
        Integer[] arr6 = Arrays.copyOfRange(arr1, 0, 2);
        System.out.println("arr6 = " + Arrays.toString(arr6));

        // 3.拷⻉数组 arr2 的后 3 位到 arr1 的后 3 位
        System.arraycopy(arr2, arr2.length-3, arr1, arr1.length-3, 3);
        System.out.println("arr1 = " + Arrays.toString(arr1));

    }

    @Test
    public void testArrayFill(){
        /*
            数组填充
            示例：定义⼀个⼤⼩为 10 的 int 数组，并将数组全部初始化为指定的值 5，打印数组；然后将数组后 3 为赋值 为 3，再次打印数组。

         */
        // 1.用for循环
        int arr[] = new int[10];
        for (int index = 0; index < arr.length; index++){
            arr[index] = 5;
        }
        System.out.println("arr = " + Arrays.toString(arr));    // arr = [5, 5, 5, 5, 5, 5, 5, 5, 5, 5]
        for (int index = arr.length-3; index < arr.length; index++){
            arr[index] = 3;
        }
        System.out.println("arr = " + Arrays.toString(arr));    // arr = [5, 5, 5, 5, 5, 5, 5, 3, 3, 3]

        // 2.用fill方法填充
        int arr2[] = new int[10];
        Arrays.fill(arr2, 5);
        System.out.println("arr2 = " + Arrays.toString(arr2));  // arr2 = [5, 5, 5, 5, 5, 5, 5, 5, 5, 5]
        Arrays.fill(arr2, arr2.length-3, arr2.length, 3);
        System.out.println("arr2 = " + Arrays.toString(arr2));  // arr2 = [5, 5, 5, 5, 5, 5, 5, 3, 3, 3]
    }

    @Test
    public void testArraySort(){
        /*
            数组排序
            示例：定义⼀个⼤⼩为 100 的 int 数组，随机给每⼀位赋值⼀个 0 ~ 100 之间的数值，然后对该数组进⾏排序 并打印排序结果。

         */
        int[] arr = new int[100];
        for (int index = 0; index < 100; index++){
            arr[index] = new Random().nextInt(100);
        }
        // System.out.println("arr = " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("arr = " + Arrays.toString(arr));

    }

    @Test
    public void testMultiArray(){
        /*
            多维数组或不规则数组
            示例：
                定义⼀个⼆维数组，第⼀维表示⽤户，
                第⼆维表示⽤户的具体信息
                    （1. 编码, 2. 姓名, 3.性别, 4.年龄）。
                定义赋值并打印。

             注：定义多维数组时，第一维必须指定长度或给其赋值
         */
        String[][] users = new String[5][];
        users[0] = new String[4];   // [Ljava.lang.String;@3c46e67a
        users[0][0] = "001";
        users[0][1] = "zs";
        users[0][2] = "男";
        users[0][3] = "20";

        users[1] = new String[4];   // [Ljava.lang.String;@c730b35
        users[1][0] = "002";
        users[1][1] = "ls";
        users[1][2] = "男";
        users[1][3] = "未知";

        System.out.println(Arrays.toString(users));
        // for循环打印多维数组
        for (int index = 0; index < users.length; index++){
            System.out.println("for循环打印\n" + Arrays.toString(users[index]));
        }
        // for-each循环打印多维数组
        for (String[] user:users){
            System.out.println("for-each循环打印\n" + Arrays.toString(user));
        }
        // lambda打印多为数组
        Arrays.asList(users).forEach(user -> System.out.println("lambda循环打印\n" + Arrays.toString(user)));

    }


    public int[] twoSum(int[] nums, int target){
        /*
            ApplyPractice：应用练习

            给定⼀个整数数组 nums 和⼀个⽬标值 target，请你在该数组中找出和为⽬标值的那 两个 整数，并返回他们的 数组下标。
            你可以假设每种输⼊只会对应⼀个答案。但是，你不能重复利⽤这个数组中同样的元素。

         */
        System.out.println("传入的数组为：nums = " + Arrays.toString(nums));
        Arrays.sort(nums);
        System.out.println("排序后的数组为：nums = " + Arrays.toString(nums));
        int times = 0;
        for (int index = 0; index < nums.length-1; index++){
            if (nums[index] >= target){
                System.out.println("第一个数（" + index + "）" + nums[index] + "已经大于" + target + ", 返回不存在") ;
                System.out.println("循环" + times + "次！");
                return null;
            }
            for (int twoIndex = index+1; twoIndex < nums.length; twoIndex++){
                times++;
                if (nums[twoIndex] > target) break;
                if (nums[index] + nums[twoIndex] == target){
                    System.out.println("循环" + times + "次！");
                    return new int[]{index, twoIndex};
                }
            }
        }

        return null;
    }

    @Test
    public void testApplyPractice(){
        /*
            ApplyPractice：应用练习

            给定⼀个整数数组 nums 和⼀个⽬标值 target，请你在该数组中找出和为⽬标值的那 两个 整数，并返回他们的 数组下标。
            你可以假设每种输⼊只会对应⼀个答案。但是，你不能重复利⽤这个数组中同样的元素。

         */

        int[] arr = {20, 2, 3, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(arr, target)));

    }








}
