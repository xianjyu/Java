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

    public void print(){
        String logStr = String.format("当前创建第%d个实例，共%d个！", index, count);
        System.out.println(logStr);
    }

    public static void main(String[] args) {
        Variable v1 = new Variable();   // 调用的无参构造方法
        v1.index = 1;
        Variable.count++;
        // System.out.println("当前类创建第" + v1.index + "个实例，共" + Variable.count + "个！");
        v1.print(); // 注：类中的方法不能通过类名调用，通过对象(即类变量)调用

        Variable v2 = new Variable();   // 调用的无参构造方法
        v2.index = 2;
        Variable.count++;
        // System.out.println("当前类创建第" + v2.index + "个实例，共" + Variable.count + "个！");
        v2.print();

        System.out.println("v1看到的count=" + v1.count);
        System.out.println("v2看到的count=" + v2.count);
        System.out.println("v1看到的index=" + v1.index);
        System.out.println("v2看到的index=" + v2.index);

        Variable v3 = new Variable(3,3);    // 调用的有参构造方法
        System.out.println("v3看到的count=" + v3.count);
        System.out.println("v3看到的index=" + v3.index);
    }
}
