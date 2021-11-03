package com.syntax.class02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW{
    WebDriver driver;
    /*
 TC 1: HRMS Add Employee:
Open chrome browser
Go to “http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login”
Login into the application
Click on Add Employee
Verify labels: Full Name, Employee Id, Photograph are displayed
Provide Employee First and Last Name
Add a picture to the profile
Verify Employee has been added successfully
Close the browser*/

    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Downloads\\chromedriver_win32 (1)version 94\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void Login(){

    }

}
