package com.cydeo.oscarReview.review05.IFrameTask;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IFrame_Task {
    WebDriver driver;

    //1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test2() {
        //2. Switch to iframe.

        WebElement iframe = driver.findElement(By.cssSelector("iframe#iframeResult"));
        //WebElement iframeXpath = driver.findElement(By.xpath("//iframe[@name='iframeResult']"));
        //driver.switchTo().frame(1);
        driver.switchTo().frame(iframe);
        //driver.switchTo().frame("iframeResult");


        //3. Get the text “Double-click me to change my text color.” and verify the text

        WebElement textLocator = driver.findElement(By.xpath("//p[@id='demo']"));
        String actualText = textLocator.getText();
        String expectedText = "Double-click me to change my text color.";

        Assert.assertTrue(actualText.equals(expectedText),"Actual and expected Text is not matching");
        //driver.switchTo().defaultContent();
        //driver.switchTo().parentFrame();

    }
}
