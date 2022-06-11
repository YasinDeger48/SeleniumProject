package com.cydeo.utilities;

/*
* In this class only general utility methods
* that are not related to some specific page
* */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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


    //Creating a utility method for ExplicitWait so we dont have to repeat the lines

    public static void waitForInvisibilityOf(WebElement webElement){

        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // o default haline getir.
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));


    }

    public static List<WebElement> getItems(){
        List<WebElement> allItems = Driver.getDriver().findElements(By.xpath("//a[@data-testid='itemDescription']"));
        return allItems;
    }

    public static String checkItems(List<WebElement> elements){
        String response = "";
        for (int i = 0; i < elements.size(); i++) {

            if(!elements.get(i).getText().toLowerCase().contains("table")){
                response= i+1 +(". item doesnt contain table keyword");
            }
        }
        return response;
    }

    public static boolean checkItem2(List<WebElement> items){
        boolean response = true;
        for (int i = 0; i < items.size(); i++) {

            if(!items.get(i).getText().toLowerCase().contains("table")){
                response= false;
            }
        }
        return response;
    }

    public static WebElement addCart(){
        WebElement element = Driver.getDriver().findElement(By.xpath("(//div[@data-testid='productBoxContainer']//input[@type='submit'])[" + BrowserUtils.getItems().size() + "]"));
        return element;

    }















}
