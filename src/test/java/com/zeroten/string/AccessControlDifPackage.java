package com.zeroten.string;

import com.zeroten.clsobj.AccessControl;
import org.testng.annotations.Test;

public class AccessControlDifPackage{
    // 四种访问权限修饰符在不同包中的权限

    @Test
    public void testAccessControlSubClass(){
        AccessControl ac = new AccessControl();
        System.out.println(ac.pub);
        System.out.println(ac.getPub());

//        System.out.println(ac.pro);
//
//        System.out.println(ac.def);
//
//        System.out.println(ac.pri);
    }
}
