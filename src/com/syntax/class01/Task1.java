package com.syntax.class01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task1 {


/* Executing different test based TestNG annotations
Create class that will have:
Before and After Class annotation
Before and After Method annotation
2 methods with Test annotation
Observe the results!*/
    @BeforeClass
    public void BeforeClass(){
        System.out.println("I am before class");
    }
    @AfterClass
    public void AfterClass(){
        System.out.println("I am after class");
    }

}