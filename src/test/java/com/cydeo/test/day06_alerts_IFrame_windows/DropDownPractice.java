package com.cydeo.test.day06_alerts_IFrame_windows;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropDownPractice {


    @Test
    public void dropdown_Task5(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");

        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));


        //Select Illinois
        BrowserUtils.sleep(1);
        dropdown.selectByVisibleText("Illinois");
        //Select VA (Virginia) with the value of attribute
        BrowserUtils.sleep(1);
        dropdown.selectByValue("VA");
        BrowserUtils.sleep(1);
        dropdown.selectByIndex(5);


        //Verification of last choose

        String expectedText = "California";
        String actualText = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualText,expectedText);


    }




}
