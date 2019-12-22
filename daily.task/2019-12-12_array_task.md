# Java Lesson

## Java字符串

## 2019-12-10

## 公告
> 今天我们学习 Java 开发中最常用的数组

- 数组
    - 数组定义及声明 
    - 数组初始化
    - 数组遍历 
    - 数组拷⻉ 
    - 数组填充 
    - 数组排序 
    - 多维数组和不规则数组 
    - 应⽤练习 
    - 常⻅⾯试问题
- 课后练习

## 1.数组
数组是⼀种数据结构，⽤来存放同⼀类型的值的集合。通过整数下标来访问数组中的值，数组下标从 0 开始； 当下标越界，不在范围之内时，程序会报错 `java.lang.ArrayIndexOutOfBoundsException`。

数组是⼀种引⽤类型，只能⽤来存储固定⼤⼩的同类型数据。在 Java 中很多集合的内部都是使⽤数组来实现 的，⽐如 ArrayList 和 HashMap 等。

数组的常⽤排序算法：冒泡算法、选择排序。


### 1.1.数组定义及声明

声明数组变量时，必须指明数组类型，类型后边紧跟 [] 或者将 [] 放在数组变量之后，数组类型可以是基本数 据类型或者引⽤类型。例如：

```
int[] arr1; 
int arr2[]; 
String[] arr3; 
String arr4[]; 

```

### 1.2.数组初始化

数组初始化有三种方式，分别为：
> 1.使用new操作符创建数组时，基本数据类型每个值会初始化为二进制0，而引用类型会初始化为null
```
public void testArrayCreate(){
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

```

>2.使⽤ new 操作符创建数组时，直接使⽤⼤括号⽅法赋值，数组的⻓度为⼤括号内元素的个数，不能在 [] 内指定⻓度，否则编译器会报错。
```
public void testArrayStatement2(){
    int[] arr = new int[] {1, 2, 3};
    String[] arrS = new String[]{"1", "2", "3"};

    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(arrS));
}
```

>3.使⽤第 2 种⽅式创建数组时，可以省略前边的 new 操作符⽽直接使⽤⼤括号。
```
public void testArrayStatement3(){
    int[] arr = { 1, 2, 3};
    String[] arrS = {"1", "2", "3"};

    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(arrS));
}
```

### 1.3.数组遍历

数组的遍历主要有以下三种方式：

>1.for 循环使⽤数组下标 
```
// for循环变量
Integer[] arr = {1, 2, 3, 4, 5};
for (int index = 0; index < arr.length; index++){
    System.out.println(String.format("下标：%d 存放的数值为：%d", index, arr[index]));
}
```

>2.for each 循环 
```
// for each
int index = 0;
for (int var : arr){
    System.out.println(String.format("第%d次取到的数值为%d", index, var));
    index++;
}
```

>3.Java 8 中新增的 Lambda 表达式
```
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
```

### 1.4.数组拷⻉
Java 中数组拷⻉常⽤的两种⽅式
>1.使⽤⼯具类 Arrays.copyOf 或 Arrays.copyOfRange 

>2.使⽤底层⽅法 System.arraycopy
```
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
```

### 1.5.数组填充
使⽤⼯具类提供的⽅法 Arrays.fill 可以对数组全部或指定范围内的元素赋值为指定的值

```
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
```

### 1.6.数组排序

可以使⽤ Arrays.sort ⽅法对数组进⾏排序。

示例：定义⼀个⼤⼩为 100 的 int 数组，随机给每⼀位赋值⼀个 0 ~ 100 之间的数值，然后对该数组进⾏排序 并打印排序结果。
```
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
```

### 1.7.多维数组和不规则数组 
前边介绍出现的数组，都是⼀维数组，Java 实际上没有多维数组，只有⼀维数组。多维数组可以被理解为“数 组的数组”。多维数组的同⼀个维可以有不同的⻓度，因此也可以称为不规则数组。声明时使⽤多个 [] 标识来声 明。
```
```

### 1.8.应⽤练习

### 1.9.常⻅⾯试问题

## 2.课后练习
 