package com.syntax.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EnableAndDisableAttribute {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Downloads\\chromedriver_win32 (1)version 94\\chromedriver.exe");
        driver = new ChromeDriver();
        String URL = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(enabled = false)
    public void validateDashboardPage(){
        System.out.println("Verifying the dashboard page");
    }

    @Test(enabled = false)
    public void validateLogo(){
        System.out.println("Verifying the logo");
    }

    @Test(priority = 2, enabled = true)
    public void validateLogout(){
        System.out.println("Verifying the logout");
    }

    @Test(priority = 1, enabled = true)
    public void validLogin(){
        WebElement userName = driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        WebElement welcomeAttribute = driver.findElement(By.id("welcome"));
        if(welcomeAttribute.isDisplayed()){
            System.out.println("Test case is valid and passed");
        }else{
            System.out.println("Test case is invalid and failed");
        }

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
