package com.syntax.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Assertion {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Downloads\\chromedriver_win32 (1)version 94\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/leave/viewLeaveList");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test()
    public void validLogin () {
        WebElement userName= driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement password= driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginbtn= driver.findElement(By.id("btnLogin"));
        loginbtn.click();

        WebElement welcomeAttribute=driver.findElement(By.id("welcome"));
        //if else is not applicable with testNG and instead we use assertion.

    }
    @Test(priority = 2, enabled = true)
    public void validationOfTitle(){
        String actualValue = "Human Management System ";
        String expectedValue = driver.getTitle();
        Assert.assertEquals(actualValue, expectedValue, "Values are not the same" );
        System.out.println("I am executing after assertion");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();


    }
}
