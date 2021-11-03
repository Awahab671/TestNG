package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ParralelTester {
    WebDriver driver;

    @DataProvider
    public Object[][] loginData(){
        Object[][] data = new Object [3][2];
        data [0][0] = "Admin";
        data [0][1]= "Hum@nhrm123";
        data [1][0]= "Wahab123";
        data [1][1]= "Abdul123@dunya";
        data [2][0]= "Admin123";
        data [2][1]= "Hum@nhrm123";
// somehow it does not log in with correct credential.
        return data;
    }

    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Downloads\\chromedriver_win32 (1)version 94\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/leave/viewLeaveList");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test(dataProvider = "loginData")
    public void validLogin1(String username, String password){
        driver.findElement(By.id("txtUsername")).sendKeys("username");
        driver.findElement(By.id("txtPassword")).sendKeys("password");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement welcomeAttribute=driver.findElement(By.id("welcome"));
        Assert.assertTrue(welcomeAttribute.isDisplayed());
    }
    @Test(dataProvider = "loginData")
    public void validLogin2(String username, String password){
        driver.findElement(By.id("txtUsername")).sendKeys("username");
        driver.findElement(By.id("txtPassword")).sendKeys("password");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement welcomeAttribute=driver.findElement(By.id("welcome"));
        Assert.assertTrue(welcomeAttribute.isDisplayed());
    }
    @Test(dataProvider = "loginData")
    public void validLogin3(String username, String password){
        driver.findElement(By.id("txtUsername")).sendKeys("username");
        driver.findElement(By.id("txtPassword")).sendKeys("password");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement welcomeAttribute=driver.findElement(By.id("welcome"));
        Assert.assertTrue(welcomeAttribute.isDisplayed());
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}



