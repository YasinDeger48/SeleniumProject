package com.cydeo.avangers.one;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase7 {

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
    public void test1() {
        driver.get("http://automationexercise.com/");
        Assert.assertTrue(driver.getWindowHandle() != null);

        //Verify title
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"HomePage is not displayed");

        WebElement testCasesText = driver.findElement(By.xpath("(//i[@class='fa fa-list'])[1]"));
        testCasesText.click();
        String expectedURL = "https://automationexercise.com/test_cases";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL,"TestCase page title is not matching with the expected title value");

    }
}
