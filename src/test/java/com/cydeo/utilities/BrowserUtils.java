package com.cydeo.utilities;

/*
* In this class only general utility methods
* that are not related to some specific page
* */

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {


    //This method using for thread.sleep.

    public static void sleep(long second){

        try{
            Thread.sleep(second*1000);
        }catch (InterruptedException e){

        }
    }

    //This method accepts 3 argument
    //1. WebDriver
    //2. expectedInURL : for verifying if the URL contains given String
    //                    - if conditions matches, will break loop
    //3. expectedInTitle: to be compared against actualTitle

    public static void switchWindowAndVerify(WebDriver driver, String expectedInURL, String expectedInTitle){

        Set<String> allWindowHandles = driver.getWindowHandles();

        //Change windows or tabs then find and break

        for (String each : allWindowHandles) {
            driver.switchTo().window(each);

            System.out.println("Current URL : " + driver.getCurrentUrl());
            if(driver.getCurrentUrl().contains(expectedInURL)){
                break;
            }

        }

        //Title assertions
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
        //Assert.assertTrue(actualTitle.startsWith(expectedInTitle));


    }


    //This method accepts a String "expectedTitle" and Asserts if it is true.

    public static void verifyTitle(WebDriver driver, String expectedTitle){

        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }















}
