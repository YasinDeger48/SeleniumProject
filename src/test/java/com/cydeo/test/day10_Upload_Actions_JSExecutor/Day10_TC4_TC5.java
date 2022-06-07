package com.cydeo.test.day10_Upload_Actions_JSExecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
public class Day10_TC4_TC5 {


    @Test
    public void scroll_practice(){

        Driver.getDriver().get("https://practice.cydeo.com/ ");
        BrowserUtils.sleep(2);


       //((JavascriptExecutor)Driver.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(2);

        actions.moveToElement(Driver.getDriver().findElement(By.id("page-footer"))).perform();
        BrowserUtils.sleep(2);


        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//a[@class='nav-link']"))).perform();

        BrowserUtils.sleep(2);

        Driver.stopSession();
    }
}
