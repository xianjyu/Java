# Java Lesson

## Java类核对象

## 2019-12-17

## 公告
+ 类和对象
    - 类和对象定义
    - 如何识别类
    - 类之间的关系
    + 类的组成
        - 域变量
        - 构造器
        - 方法
        + 修饰符
            - 访问权限修饰符
            - static修饰符
            - final修饰符
        - 代码块
        - 包
    - 创建对象
+ 应用练习
+ 常见面试问题

## 1.类和对象
Java 是⼀⻔⾯向对象的程序设计语⾔，它把⼀切都看作是对象，Java 源代码都是以类的形式来组织。
⾸先我们来看⼀下类和对象的概念：
### 1.1.类和对象定义
> 类的定义

类是构造对象的模版或者蓝图，它定义了⼀类对象的状态和⾏为，从形式来看是将数据和⾏为封装放在 ⼀个类⾥。类中的数据称为实例域（instance ﬁeld），操作数据的过程称为⽅法（method）。

> 对象的定义

对象是类的⼀个实例，有状态和⾏为。每个类实例（对象）都有⼀组特定的实例域值，这些值的集合就 是这个对象的当前状态（state）。

例如：⼈是⼀个类，他的状态有：姓名、性别、年龄、身⾼、体重等；他的⾏为有：⾛路、吃饭、睡觉、⼯ 作、学习等。⽽具体的每⼀个⼈则为该类的对象（object）。
```
public class Person {
    // 下面这些定义的变量称作：域变量
    private String name;
    private int age;
    private Integer sex;
    private double height;
    private double weight;

    public void walking(){}

    public void eat(){}

    public void sleep(){}

    public void work(){}

    public void study(){}

}
```

而每一个人，也就是根据类 `Person` 构造出来的对象则是该类的实例对象，例如下边构造了 Person1、Person2、Person3三个实例

```
Person person1 = new Person();
Person person2 = new Person();
Person person3 = new Person();

```

### 1.2.如何识别类
如何进⾏⾯向对象编程（OOP），我们通常是从设计类开始，然后再向类中添加属性和⽅法。

那么怎么来识别类？有⼀个简单的规则：在分析问题的过程中寻找名词，⽽⽅法对应着动词。

例如：我们来分析订单处理系统，有这样⼀些名词：
+ 商品（Item） 
+ 订单（Order） 
+ 送货地址（Shipping address） 
+ 付款（Payment） 
+ 账户（Account）

接下来分析⼀下有哪些动词：
+ 添加购物⻋ 
+ 提交订单 
+ ⽀付订单 
+ 取消订单

对于这些动词：添加、提交、⽀付、取消，我们还要标识出完成这些动作相对应的对象。

### 1.3.类之间的关系
类之间最常见的关系有：

> 依赖（uses-a）

⼀个类 A 的⽅法操作了另⼀个类 B 的对象，我们就说 A 依赖于 B。例如：订单对象 Order 需要访问账户 Account 对象来看该客户是否可参与活动、是否有会员折扣等，因此 Order 依赖于 Account。⽽商品 （Item）对象和客户账户⽆关。

> 聚合（has-a）

类 A 的对象包含类 B 的对象，我们称之为聚合。例如：⼀个 Order 订单对象包含⼀个或多个 Item 商品 对象，因此它们是聚合关系。


> 继承（is-a）

继承关系表示：类 A 从类 B 扩展⽽来，类 A 不但包含从类 B 继承的属性和⽅法，还拥有⼀些额外的属 性和⽅法。


### 1.4.类的组成
Java 类主要由以下 7 部分组成：
+ 包定义 
+ 包导⼊ 
+ 域（Field）/成员变量（Member variable） 
    - 实例变量，不以 static 修饰的变量 
    - 类变量，以 static 修饰的变量 
+ ⽅法（method）：对象的⾏为 
+ 构造⽅法：⽤于对象的实例化 
+ 内部类（inner class）：在类中声明的其他类 
+ 代码块 
    - 实例块 
    - 静态
#### 1.4.1域变量
在类中，⽅法之外定义的变量我们称为域变量，也叫成员变量，它分为两种：
+ 实例变量，不以 static 修饰的变量 
+ 类变量，也可以称为静态变量或静态域，以 static 修饰的变量

而在方法中的变量我们成为局部变量
```
public class Variable {
    /*
        使用static修饰符修饰的是类变量，所有的实例共享
        count用于记录创建该类的实例个数
    */
    public static int count = 0;
    /*
        没有使用static修饰符修饰的是实例变量，每个实例单独的拷贝
        index用于存放当前类的第几个实例
    */
    public int index;

    public static void main(String[] args) {
        Variable v1 = new Variable();
        v1.index = 1;
        Variable.count++;
        System.out.println("当前类创建第" + v1.index + "个实例，共" + Variable.count + "个！");

        Variable v2 = new Variable();
        v2.index = 2;
        Variable.count++;
        System.out.println("当前类创建第" + v2.index + "个实例，共" + Variable.count + "个！");

        System.out.println("v1看到的count=" + v1.count);
        System.out.println("v2看到的count=" + v2.count);
        System.out.println("v1看到的index=" + v1.index);
        System.out.println("v2看到的index=" + v2.index);


    }
}
```

#### 1.4.2构造器
要使用对象，就必须先构造对象，并指定其初始状态。Java使用构造器 `(constructor)` 构造新的实例。

构造器是一种特殊的方法，用来构造并初始化对象
+ 构造器的名字和类名相同
+ 没有返回值
+ 构造器是伴随 `new` 操作符的执行而被调用

类构造器的重载：一个类可以有多个构造器，它们的名字和类名相同，但是参数个数和参数类型不一样。

在编写一个类时，如果没有编写构造器，那么系统会提供一个无参的构造器，但是如果编写了构造器，系统就不会再提供无参的构造器。

通过 `new` 定义赋值的变量也叫对象变量，一个对象变量并没有实际包含一个对象，而仅仅引用一个对象。

在Java中所有变量的值都是存储在另一个地方的一个对象的引用，所有Java对象都存储在堆中。

当有多个构造器时，可以用 `this` 关键字， 并且调用语句只能出现在该方法第一句，而且只能调用一个构造器方法。
```java
package com.zeroten.clsobj;

public class Variable {
    public String name;
    /*
        使用static修饰符修饰的是类变量，所有的实例共享
        count用于记录创建该类的实例个数
    */
    public static int count = 0;
    /*
        没有使用static修饰符修饰的是实例变量，每个实例单独的拷贝
        index用于存放当前类的第几个实例
    */
    public int index;

    /* 无参构造方法 */
    public Variable(){ System.out.println("无参构造的方法被调用了……"); }

    /* 多个参数的构造方法 */
    public Variable(String name, int count, int index){
        this(count, index);     // this关键字直接放在当前方法的第一行
        this.name = name;
        System.out.println("三个有参构造的方法被调用了……");
    }

    /* 有参构造方 */
    public Variable(int count, int index){
        this();     // 调用无参构造方法
        this.count = count;
        this.index = index;
        System.out.println("两个有参构造的方法被调用了……");
    }

    public static void main(String[] args) {
        Variable v1 = new Variable();   // 调用的无参构造方法
        v1.index = 1;
        Variable.count++;
        System.out.println("当前类创建第" + v1.index + "个实例，共" + Variable.count + "个！");

        Variable v2 = new Variable();   // 调用的无参构造方法
        v2.index = 2;
        Variable.count++;
        System.out.println("当前类创建第" + v2.index + "个实例，共" + Variable.count + "个！");

        System.out.println("v1看到的count=" + v1.count);
        System.out.println("v2看到的count=" + v2.count);
        System.out.println("v1看到的index=" + v1.index);
        System.out.println("v2看到的index=" + v2.index);

        Variable v3 = new Variable(3,3);    // 调用的有参构造方法
        System.out.println("v3看到的count=" + v3.count);
        System.out.println("v3看到的index=" + v3.index);



    }
}

```

综上所诉：Java的类构造器有如下一些特征
+ 构造器和类同名
+ 每个类可以有一个或多个构造器，但是参数个数和参数类型不一致
+ 构造器没有返回值 `void`
+ 构造器总数伴随着 `new` 操作一起被调用
+ 编写类时未编写构造器，系统会默认提供一个无参构造
+ `this` 关键字调用构造器方法只能出现在第一行，并且只能调用一个构造器
+ 对于类中定义的方法是不能通过类名来调用的

#### 1.4.2方法
方法即对象行为，用于操作对象以及存取它们的实例域(前面提到的实例变量和域变量)

方法也可以称为函数，一个方法的定义如下：
```
(访问权限修饰符) (修饰符) 返回值数据类型 方法名(形式参数列表){
    语句;
    return 返回值；    
}
```
如果方法没有返回值则使用 `void` 来定义返回值类型

>方法参数

Java 语⾔总是采⽤按值调⽤（call by value），⽅法得到的是所有参数值的⼀个拷⻉，⽅法是不能修改传递给他 的任何参数变量的内容。⽅法参数总共有两种类型：
+ 基本数据类型  
+ 对象引用

一个方法不能修改一个基本数据类型的参数，也不能修改引用类型参数的指向，但是却可以修改引用类型参数指向对象的值。
```java
package com.zeroten.clsobj;

import org.testng.annotations.Test;

// 方法参数
public class MethodParam {

    /*

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
```

>隐式参数

隐式参数 `this` ：Java编译器在编译时会将对象自己放在第一个参数上，我们称之为隐式参数，第二个参数开始才是位于方法名后边括号中的参数，这些称之为显示参数。

使用关键字 `this` 来表示第一个隐式参数，因此可以在方法内使用 `this`来访问对象自己的其他成员变量或方法。

当没有使用 `this.` 前缀来访问一个变量时，首先看是否存在该名字的局部变量，如果不存在则再去看该对象是否存在改名字的成员变量。

```java
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
}
``` 

>可变参数

可变参数：当我们需要传同一类型的一组参数，但是却不知道参数个数，这时可以使用可变参数。

可变参数语法： `参数类型... 变量名`

一个方法只能有一个可变参数，并且可变参数只能是最后一个，可变参数变量我们可以当做是一个数组来使用

```
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
```

>方法重载

上面提到类的构造器可以重载，普通方法也可以重载。重载(overloading)指的是方法名相同，但是方法的参数类型或个数不同

```java
package com.zeroten.clsobj;

import org.testng.annotations.Test;

public class MethodOverloading {

    public void print(){
        System.out.println("print method!");
    }

    public void print(int num){}

    public void print(int num1, int num2){}

    public void print(String str1){}

    public void print(String str1, String str2){}

    @Test
    public void testMethodOverloading(){
        print();
        print(1);
        print("1");
        print("a", "b");
    }

}
```
不能根据返回值类型来区分重载，为什么？ 看如下代码定义了2个返回值类型不同但但是方面名字和参数个数、参数类型相同的方法，如果调用的时候直接调用而没有将结果赋给一个变量，那么编译器就不知道该调那个方法了
```
int max(int n1, int n2);
long max(int n1, int n2);
max(1, 3);
```

>签名
+ 方法名和参数个数、参数类型，我们称为方法的签名(signature)。
+ 方法名必须唯一，方法的返回值类型不是方法签名的一部分。

#### 1.4.3修饰符

Java语言中提供了一些修饰符，用来定义类、成员变量和方法，它放在语句的最前端，主要分为以下两类：
+ 访问修饰符
+ 非访问修饰符

##### 1.4.3.1.访问权限修饰符

在Java中通过访问控制修饰符来限定对类、成员变量和访问的访问，Java支持4种权限访问

|修饰符|说明|当前类|同包|子类|不同包|备注|
| ------ | ------ | ------ | ------ | ------ | ------| ------|
|public|公开|√|√|√|√|可用于类、接口、成员变量、方法|
|protected|保护|√|√|√|×|可用于成员变量、方法|
|default|默认|√|√|×|×|可用于类、接口、成员变量、方法|
|private|私有|√|×|×|×|可用于成员变量、方法|

##### 1.4.3.2.static修饰符

使用 `static` 修饰符定义的成员变量和方法称为静态域和静态方法，使用类名来访问，也可以使用类的实例变量名来访问。

类的所有实例对象共享一个变量，在静态方法中可以访问静态域变量，但是不能访问非静态的域变量。


##### 1.4.3.2.final修饰符

#### 1.4.4.代码块

#### 1.4.5.包

### 1.5.创建对象

## 2.应用练习

## 3.常见面试问题