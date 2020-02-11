package com.zeroten.string;

import com.zeroten.clsobj.AccessControl;
import org.testng.annotations.Test;

public class AccessControlSubClass extends AccessControl {
    // 四种访问权限修饰符在子类中的权限(并且是不在同一个包中)

    @Test
    public void testAccessControlSubClass(){
        System.out.println(pub);
        System.out.println(getPub());

        System.out.println(pro);
        System.out.println(getPro());

//        System.out.println(def);

//        System.out.println(pri);
    }
}
