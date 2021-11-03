package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class CommonMethods {

    public static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        configReader.readProperties("C:\\Users\\pc\\IdeaProjects\\Batch10 TestNG\\src\\config\\config.properties");
        switch (configReader.getPropertyValue("browser")) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Downloads\\chromedriver_win32 (1)version 94\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.out.println("Browser not available");
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }
            driver.get(configReader.getPropertyValue("url"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }


    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    }



