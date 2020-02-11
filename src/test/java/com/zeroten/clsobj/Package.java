package com.zeroten.clsobj;

import org.testng.annotations.Test;

import java.util.Date;

public class Package {

    @Test
    public void testPackage(){
        java.util.Date date = new java.util.Date();
        System.out.println(date.toString());

        Date date2 = new Date();
        System.out.println(date2.toString());
    }
}
