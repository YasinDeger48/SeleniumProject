package com.cydeo.test.day05_Intro_Dropdowns;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T7_NonSelectDropDown {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com//dropdown");
    }

    @AfterClass
    public void finish() {
        driver.quit();
    }

    @Test
    public void facebook(){
        WebElement dropdown = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']")) ;
        dropdown.click();
        WebElement facebookElement = dropdown.findElement(By.xpath("//a[@href='https://www.facebook.com/']"));
        facebookElement.click();
        String expectedTitle = "Facebook - Log In or Sign Up"; // " Facebook – log in or sign up "
        String actualTitle = driver.getTitle();


        Assert.assertEquals(actualTitle,expectedTitle);

        BrowserUtils.sleep(2);




    }


}
