package com.syntax.class02;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Groupings {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am before method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after method");
    }
    @Test(groups = {"smoke"})
    public void testMethod(){
        System.out.println("This is my first method. ");
    }
    @Test(groups = {"smoke"})
    public void antherMethod(){
        System.out.println("This is the second method.");
    }
    @Test(groups = {"regression"})
    public void ThirdMEthod(){
        System.out.println("Third method.");
    }
}
