package com.cydeo.test.day10_Upload_Actions_JSExecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class day10_TC3_Actions_Hover {





    @Test
    public void hovering_test(){

        //1. Go to https://practice.cydeo.com/hovers

        Driver.getDriver().get("https://practice.cydeo.com/hovers");

        WebElement firstImage = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement secondImage = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement thirdImage = Driver.getDriver().findElement(By.xpath("(//img)[3]"));

        //locate all the "user" texts under here:
        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));

        Actions actions = new Actions(Driver.getDriver());

        //2. Hover over to first image
        actions.moveToElement(firstImage).perform();
        BrowserUtils.sleep(2);
        //3. Assert:
        Assert.assertTrue(user1.isDisplayed(),"user1 is not displayed");

        
        System.out.println("-------------------");


        actions.moveToElement(secondImage).perform();
        BrowserUtils.sleep(2);
        //3. Assert:
        Assert.assertTrue(user2.isDisplayed(),"user2 is not displayed");

        System.out.println("-------------------");

        actions.moveToElement(thirdImage).perform();
        BrowserUtils.sleep(2);
        //3. Assert:
        Assert.assertTrue(user3.isDisplayed(),"user3 is not displayed");

        Driver.stopSession();
    }

    /*TC #3: Hover Test

2. Hover over to first image
3. Assert:
a. “name: user1” is displayed
b. “view profile” is displayed
4. Hover over to second image
5. Assert:
a. “name: user2” is displayed
b. “view profile” is displayed
6. Hover over to third image
7. Confirm:
a. “name: user3” is displayed
b. “view profile” is displayed
    * */
}
