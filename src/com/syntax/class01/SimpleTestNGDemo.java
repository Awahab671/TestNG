package com.syntax.class01;
import org.testng.annotations.*;

public class SimpleTestNGDemo {


    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am before method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after method");
    }
    @Test
    public void testMethod(){
        System.out.println("This is my first method. ");
    }
    @Test()
    public void antherMethod(){
        System.out.println("This is the second method.");
    }
    @Test()
    public void ThirdMEthod(){
        System.out.println("Third method.");
    }
}
