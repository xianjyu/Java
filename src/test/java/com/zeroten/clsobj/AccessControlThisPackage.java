package com.zeroten.clsobj;

import org.testng.annotations.Test;

public class AccessControlThisPackage {

    @Test
    public void testAccessControlThisPackage(){
        // 访问四种权限修饰符在当前包下的权限

        AccessControl ac = new AccessControl();
        System.out.println(ac.pub);
        System.out.println(ac.getPub());

        System.out.println(ac.pro);
        System.out.println(ac.getPro());

        System.out.println(ac.def);
        System.out.println(ac.getDef());

//        System.out.println(ac.pri);
        System.out.println(ac.getPri());    // getPri()方法是可以访问的
    }
}
