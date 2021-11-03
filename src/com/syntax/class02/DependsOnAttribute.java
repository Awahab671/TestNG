package com.syntax.class02;

import org.testng.annotations.Test;

public class DependsOnAttribute {

    @Test
    public void login(){
        System.out.println("This is my login method");
    }
    @Test (dependsOnMethods = "login")
    public void verifyDashboardPage(){
        System.out.println("This is my dashboard page.");
    }
    @Test (dependsOnMethods = {"login","verifyDashboardPage"})
    public void verifyLogout(){
        System.out.println("This is my logout page.");
    }
}
