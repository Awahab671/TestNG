package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertion2 {

    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Downloads\\chromedriver_win32 (1)version 94\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/leave/viewLeaveList");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test(groups = {"smoke"})
    public void validLogin () {
        String titleExpected="Human Resource Management System";
        String titleActual=driver.getTitle();


        SoftAssert soft = new SoftAssert();
        soft.assertEquals(titleActual, titleExpected);
        WebElement userName= driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement password= driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginbtn= driver.findElement(By.id("btnLogin"));
        loginbtn.click();

        WebElement welcomeAttribute=driver.findElement(By.id("welcome"));
        soft.assertFalse(welcomeAttribute.isDisplayed());


        String text = welcomeAttribute.getText();
        String expectedText = "Welcome Admin123";

        soft.assertEquals(text, expectedText);
        System.out.println("My statement after all the assertion");
        soft.assertAll();
    }
    @Test
    public void invalidLogin(){
        String titleExpected="Human Resource Management System";
        String titleActual=driver.getTitle();


    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

}
