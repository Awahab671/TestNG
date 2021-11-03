package com.syntax.class01;

import org.testng.annotations.Test;

public class PriorityAttribute {
    @Test(priority = 3)
    public void login(){
        System.out.println("Logging in");
    }
    @Test(priority = 1)
    public void launchBrowser(){
        System.out.println("Launching Browser");
    }
    @Test(priority =2)
    public void navigateUrl(){
        System.out.println("Navigate the url");
    }
    @Test(priority = 4)
    public void closeBrowser(){
        System.out.println("Closing browser");
    }
}
