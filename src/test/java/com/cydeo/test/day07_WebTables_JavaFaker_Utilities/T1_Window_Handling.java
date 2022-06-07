package com.cydeo.test.day07_WebTables_JavaFaker_Utilities;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_Window_Handling {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void window_handling_test(){

        driver.get("https://www.amazon.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank')");
        js.executeScript("window.open('https://etsy.com','_blank');");
        js.executeScript("window.open('https://facebook.com','_blank');");


        BrowserUtils.switchWindowAndVerify(driver,"etsy","Etsy");
        BrowserUtils.verifyTitle(driver, "Etsy Turkey - Shop for handmade, vintage, custom, and unique gifts for everyone");

        //Aşağıdaki kodların yerine yazdık.



        /*Set<String> allWindowHandles = driver.getWindowHandles();

        for (String each : allWindowHandles) {
            driver.switchTo().window(each);
            Wait.wait(2);
            System.out.println("Current URL : " + driver.getCurrentUrl());
            if(driver.getCurrentUrl().contains("etsy")){
                break;
            }

        }
        String actualTitle = driver.getTitle();
        //System.out.println("actualTitle = " + actualTitle);
        String expectedTitle = "Etsy";
        //Assert.assertEquals(actualTitle, expectedTitle);
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        Assert.assertTrue(actualTitle.startsWith(expectedTitle));*/

    }
}
