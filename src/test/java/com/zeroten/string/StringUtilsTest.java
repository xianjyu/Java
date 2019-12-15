package com.zeroten.string;

import com.javales.util.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *  业务类：StringUtilsTest
 */
public class StringUtilsTest {

    @Test
    public void testTrimAll(){
        // 去掉字符串开头/结尾/中间的空格（不使⽤trim⽅法）
        Assert.assertEquals(StringUtils.trimAll("  Hello  "), "Hello");

    }

    @Test
    public void testTrimAll2(){
        Assert.assertEquals(StringUtils.trimAllChar("  H e l l o  "), "Hello");
    }

    @Test
    public void testReverseStr(){
        Assert.assertEquals(StringUtils.reverseStr("123"), "321");
        Assert.assertEquals(StringUtils.reverseStr("hello"), "olleh");
    }
}
