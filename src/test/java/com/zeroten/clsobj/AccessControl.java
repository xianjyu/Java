package com.zeroten.clsobj;

import org.testng.annotations.Test;

public class AccessControl {
    public String pub = "public_公共";
    protected String pro = "protected_保护";
    String def = "default_默认";
    private String pri = "private_私有";

    public String getPub(){
        return pub;
    }

    public String getPro(){
        return pro;
    }

    public String getDef(){
        return def;
    }

    public String getPri(){
        return pri;
    }

    @Test
    public void testThisClass(){
        // 测试四种访问权限修饰符的访问权限啊
        System.out.println(pub);
        System.out.println(pro);
        System.out.println(def);
        System.out.println(pri);

        System.out.println(getPub());
        System.out.println(getPro());
        System.out.println(getDef());
        System.out.println(getPri());

    }
}
