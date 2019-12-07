package com.zeroten.flow;

import com.javales.flow.AgeCheck;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AgeCheckTest {

    /**
     * 测试驱动开发：简称TDD，原名为Test-Driven Development
     * 简单来说：TDD的核心思想是先写测试，再写实现
     */

    @Test
    public void testAgeCheck1(){
        // 0 ~ 6岁:儿童 ,7 ~ 17岁：少年 ,18 ~ 40岁：青年 ,41 ~ 59岁：中年,60及以上：老年
        // 写测试类的三段式：given when then
        Assert.assertEquals(AgeCheck.getAgeName(6), "儿童");
        Assert.assertEquals(AgeCheck.getAgeName(10), "少年");
        Assert.assertEquals(AgeCheck.getAgeName(18), "青年");
    }

    @Test
    public void testAgeCheck2(){
        Assert.assertEquals(AgeCheck.getAgeName(50), "中年");
        Assert.assertEquals(AgeCheck.getAgeName(60), "老年");
        Assert.assertEquals(AgeCheck.getAgeName(80), "老年");
    }
}
