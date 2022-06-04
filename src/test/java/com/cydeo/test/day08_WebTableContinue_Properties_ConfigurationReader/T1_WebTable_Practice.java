package com.cydeo.test.day08_WebTableContinue_Properties_ConfigurationReader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WebTable_Practice {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void order_name_verify_text(){
        WebElement bobMartinElement = driver.findElement(By.xpath("//table[@class='SampleTable']//tbody//td[.='Bob Martin']"));
        String actualText = bobMartinElement.getText();
        String expectedText = "Bob Martin";
        Assert.assertTrue(actualText.equals(expectedText),"does not match");

        WebElement bobMartinDate = driver.findElement(By.xpath("//table[@class='SampleTable']//tbody//td[.='12/31/2021']"));
        String actualDate = bobMartinDate.getText();
        String expectedDate = "12/31/2021";
        Assert.assertTrue(actualDate.equals(expectedDate),"date does not match");
    }

    @Test
    public void util_test(){

        System.out.println(WebTableUtils.returnOrderDate(driver, "Samuel Jackson"));
        WebTableUtils.orderVerify(driver,"Samuel Jackson","12/21/2021");
    }
}
