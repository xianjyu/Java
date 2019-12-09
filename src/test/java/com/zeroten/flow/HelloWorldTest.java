package com.zeroten.flow;

import com.javales.flow.HelloWorld;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HelloWorldTest {

    @Test
    public void testHelloWorld(){
        // Assert.assertEquals(Prints.print("Hello World"), "Hello World");
        Assert.assertEquals(HelloWorld.print("Hello World!"), "Hello World!");
    }
}
