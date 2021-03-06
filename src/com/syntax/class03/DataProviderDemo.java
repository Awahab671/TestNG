package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CommonMethods;
import utils.configReader;

import java.util.concurrent.TimeUnit;

public class DataProviderDemo extends CommonMethods{
        @DataProvider
        public Object[][] loginData() {
            Object data[][] = new Object[4][2];
            data[0][0] = "Hum@nhrm123";  // here we switched username with password
            data[0][1] = "Admin";
            data[1][0] = "Michael12345"; // here we created a new user
            data[1][1] = "Hum@nhrm123";
            data[2][0] = "Admin123";    // here we made the credentials wrong
            data[2][1] = "Hum@nhrm123";
            data[3][0] = "Admin";
            data[3][1] = "Hum@nhrm123";

            return data;
        }

        // In this class we deleted the url and webdriver section plus afterMethod and beforeMethod because we put them
        // in properties class of utils package, and we can use them for all future classes.

        @Test()
        public void validLogin() {
            driver.findElement(By.id("txtUsername")).sendKeys(configReader.getPropertyValue("username"));
                    driver.findElement(By.id("txtPassword")).sendKeys(configReader.getPropertyValue("password"));
            driver.findElement(By.id("btnLogin")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            WebElement welcomeAttribute = driver.findElement(By.xpath("//*[@id='welcome']"));
            Assert.assertTrue(welcomeAttribute.isDisplayed());
        }

    }

