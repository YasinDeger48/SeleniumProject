package com.cydeo.oscarReview.review06.tests;

import com.cydeo.oscarReview.review06.pomForReview.CherCherHomepage;
import com.cydeo.oscarReview.review06.pomForReview.WebRestaurantPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WebRestaurantTest {

    WebRestaurantPage restaurantPage;
    WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigReader.getProperty("restaurant"));
        restaurantPage = new WebRestaurantPage();
        wait = new WebDriverWait(Driver.getDriver(),10);
    }


    @AfterMethod
    public void tearDown(){
        BrowserUtils.sleep(2);
        Driver.stopSession();
    }

    @Test
    public void restaurant_cart_test(){

        restaurantPage.searchBar.sendKeys("stainless work table", Keys.ENTER);
        Assert.assertTrue(BrowserUtils.checkItem2(BrowserUtils.getItems()),"Title checked error");
        BrowserUtils.addCart().click();
        BrowserUtils.sleep(1);
        restaurantPage.viewCartButton.click();
        restaurantPage.emptyCartButton.click();
        restaurantPage.emptyCartAlertButton.click();
        String expectedHeader = "Your cart is empty.";
        String actualHeader = restaurantPage.yourCartIsEmptyMessage.getText();
        Assert.assertTrue(actualHeader.equals(expectedHeader),"Header was not shown as 'Your cart is Empty'");

    }


    }

