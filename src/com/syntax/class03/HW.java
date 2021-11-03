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
import java.util.zip.DataFormatException;

public class HW {

WebDriver driver;

@DataProvider
    public Object [][] addEmployeeData(){
    Object [][] data = new Object[5][5];
    data[0][0] = "Firstname1";
    data[0][1]= "Lastname1";
    data[0][2] = "username1111";
    data[0][3]= "Hum@nhrm123";
    data[0][4] = "Hum@nhrm123";
    data[1][0]= "Firstname2";
    data[1][1] = "Lastname2";
    data[1][2]= "username2222";
    data[1][3] = "Hum@nhrm123";
    data[1][4]= "Hum@nhrm123";
    data[2][0] = "Firstname3";
    data[2][1]= "Lastname3";
    data[2][2] = "username3333";
    data[2][3]= "Hum@nhrm123";
    data[2][4] = "Hum@nhrm123";
    data[3][0]= "Firstname4";
    data[3][1] = "Lastname4";
    data[3][2]= "username4444";
    data[3][3] = "Hum@nhrm123";
    data[3][4]= "Hum@nhrm123";
    data[4][0]= "Firstname5";
    data[4][1] = "Lastname5";
    data[4][2]= "username5555";
    data[4][3] = "Hum@nhrm123";
    data[4][4]= "Hum@nhrm123";

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

@Test(dataProvider = "addEmployeeData", groups = "smoke")
public void addEmployeeMethod(String Firstname, String Lastname, String username, String Password, String ConfirmPassword){
    WebElement userName= driver.findElement(By.id("txtUsername"));
    userName.sendKeys("Admin");
    WebElement password= driver.findElement(By.id("txtPassword"));
    password.sendKeys("Hum@nhrm123");
    WebElement loginbtn= driver.findElement(By.id("btnLogin"));
    loginbtn.click();

    driver.findElement(By.id("menu_pim_viewPimModule")).click();
    driver.findElement(By.id("menu_pim_addEmployee")).click();
    driver.findElement(By.id("firstName")).sendKeys(Firstname);
    driver.findElement(By.id("lastName")).sendKeys(Lastname);
    driver.findElement(By.id("chkLogin")).click();
    driver.findElement(By.id("user_name")).sendKeys(username);
    driver.findElement(By.id("user_password")).sendKeys(Password);
    driver.findElement(By.id("re_password")).sendKeys(Password);
    driver.findElement(By.id("btnSave")).click();


    WebElement createName = driver.findElement(By.xpath("//div[@id = 'profile-pic']/hr"));
    String createdNameText = createName.getText();
    Assert.assertEquals(createdNameText, Firstname+" "+ Lastname, "Employees wan not");


}

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}

