package com.cydeo.myExamples;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TitleVerification {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/test/newtours/");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void verifyTitle(){
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle,"WebSite Title is not matching with expected value");



    }


}
