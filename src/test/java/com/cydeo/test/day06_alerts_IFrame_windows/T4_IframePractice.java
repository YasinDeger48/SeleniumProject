package com.cydeo.test.day06_alerts_IFrame_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_IframePractice {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/iframe");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void iframe_test1(){

        //Method1
        WebElement iFrame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrame); //iframe webElement i ile iframe e geçme yöntemi

        //Method2
        //driver.switchTo().frame("mce_0_ifr"); //frame id ile iframe e geçme yöntemi

        //Method3
        //driver.switchTo().frame(0); //frame index starts with `0`

        //Locate the p tag // direk p ye ulaşamayız önce iframe i göstermemiz lazım
        WebElement pTagLocators = driver.findElement(By.xpath("//p"));

        Assert.assertTrue(pTagLocators.isDisplayed());

        driver.switchTo().parentFrame();

        String expectedTitle = "An iFrame containing the TinyMCE WYSIWYG Editor";
        String actualTitle = driver.findElement(By.xpath("//h3")).getText();

        Assert.assertEquals(actualTitle, expectedTitle, "actual and excepted title is not same");

    }
}
