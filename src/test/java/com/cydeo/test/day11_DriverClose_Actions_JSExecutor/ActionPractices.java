package com.cydeo.test.day11_DriverClose_Actions_JSExecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionPractices {

    @Test
    public void task4_task5_test(){

        Driver.getDriver().get("https://practice.cydeo.com/ ");
        BrowserUtils.sleep(2);


        //((JavascriptExecutor)Driver.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(2);

        WebElement cydeoLinkBottom = Driver.getDriver().findElement(By.id("page-footer"));
        actions.moveToElement(cydeoLinkBottom).perform();
        BrowserUtils.sleep(2);


        //actions.moveToElement(Driver.getDriver().findElement(By.xpath("//a[@class='nav-link']"))).perform();

        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();
        BrowserUtils.sleep(2);

        Driver.stopSession();



    }
}
