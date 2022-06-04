package com.cydeo.myExamples;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ALCPT {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://alcpts.com/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1(){
        WebElement enterButton = driver.findElement(By.linkText("Click to continue to the site"));
        enterButton.click();
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://alcpts.com/home-page/";

        Assert.assertEquals(currentURL,expectedURL,"URL is not matching");
    }


}
