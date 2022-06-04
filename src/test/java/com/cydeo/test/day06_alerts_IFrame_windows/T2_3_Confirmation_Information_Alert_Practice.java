package com.cydeo.test.day06_alerts_IFrame_windows;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T2_3_Confirmation_Information_Alert_Practice {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testCase01(){
        //Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("https://practice.cydeo.com/javascript_alerts");

        //Click to “Click for JS Confirm” button
        WebElement clickJSConfirmButton = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
        clickJSConfirmButton.click();

        //Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //Verify “You clicked: Ok” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResultText = resultText.getText();
        String expectedResultText = "You clicked: Ok";
        Assert.assertTrue(actualResultText.equals(expectedResultText),"Result text is not matching with the expected text");


    }

    @Test
    public void testCase02(){
        //Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("https://practice.cydeo.com/javascript_alerts");

        //Click to “Click for JS Prompt” button
        WebElement promptButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        promptButton.click();

        //Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        BrowserUtils.sleep(1);

        //Click to OK button from the alert
        alert.accept();

        //Verify “You entered: hello” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
        String expectedResultText = "You entered: hello";
        BrowserUtils.sleep(1);
        String actualResultText = resultText.getText();
        Assert.assertTrue(actualResultText.equals(expectedResultText),"Actual result text is not matching with the expected result text");

    }


}
