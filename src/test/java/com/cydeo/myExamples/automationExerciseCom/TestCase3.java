package com.cydeo.myExamples.automationExerciseCom;

import com.cydeo.utilities.WebDriverFactory;
import com.google.common.base.Verify;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase3 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.automationexercise.com/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void test3(){
        //3. Verify that home page is visible successfully

        String actualTitle = driver.getTitle();
        String expectedTitle = "Automation Exercise";
        Assert.assertEquals(driver.getWindowHandle() !=null,actualTitle.equals(expectedTitle));




    }

}
