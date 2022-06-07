package com.cydeo.oscarReview.reviewWeekTasks;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task1 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void task1() {
//    1.	Go to https://www.amazon.com
        driver.get("https://www.amazon.com");

        //            2.	Search for "hats for men" (Call from Configuration.properties file)
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        BrowserUtils.sleep(2);
        searchBox.sendKeys("hats for men" + Keys.ENTER);

        //            3.	Add the first hat appearing to Cart with quantity 2
        WebElement firstElement = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-base'])[1]"));
        BrowserUtils.sleep(2);
        firstElement.click();
        BrowserUtils.sleep(2);

        //            4.	Open cart and assert that the total price and quantity are correct

        WebElement quantitySelect = driver.findElement(By.xpath("(//span[@class='a-dropdown-prompt'])[1]"));
        quantitySelect.click();

        driver.findElement(By.id("quantity_1")).click();
        BrowserUtils.sleep(2);
        driver.findElement(By.id("add-to-cart-button")).click();

        driver.findElement(By.xpath("(//span[@class='a-button-inner'])[2]")).click();



        driver.findElement(By.xpath("(//span[@class='a-dropdown-prompt'])[1]")).click();

        //5.	Reduce the quantity from 2 to 1 in Cart for the item selected in the step 3

        driver.findElement(By.id("quantity_1")).click();
        BrowserUtils.sleep(2);


        WebElement itemNumber = driver.findElement(By.xpath("//span[@id='sc-subtotal-label-buybox']"));

        String expectedItem = "(1 item)";
        String actualItem = itemNumber.getText();

        System.out.println("actualItem = " + actualItem);

        Assert.assertTrue(actualItem.contains(expectedItem), "Item number is not correct");


        WebElement price = driver.findElement(By.xpath("//span[@id='sw-subtotal-item-count']//following-sibling::span[1]"));

        String expectedPrice = "$35.98";
        String actualPrice = price.getText();

        Assert.assertTrue(actualPrice.equals(expectedPrice), "Price is not matching with expected Price");

        driver.findElement(By.xpath("//a[@class='a-button-text']")).click();

        driver.findElement(By.xpath("(//span[@class='a-dropdown-prompt'])[1]")).click();

        //5.	Reduce the quantity from 2 to 1 in Cart for the item selected in the step 3

        driver.findElement(By.id("quantity_1")).click();
        BrowserUtils.sleep(2);

        //            6.	Assert that the total price and quantity has been correctly changed

        WebElement itemNumberCheck = driver.findElement(By.cssSelector("#sc-subtotal-label-activecart"));
        String actualItemCheck = itemNumberCheck.getText();
        String expectedItemCheck = "(1 item)";

        WebElement priceCheck = driver.findElement(By.xpath("//span[@id='sc-subtotal-label-activecart']//following-sibling::span[1]"));
        String actualPriceCheck = priceCheck.getText();
        String expectedPriceCheck = "$19.99";


        Assert.assertTrue(actualItemCheck.contains(expectedItemCheck), "Actual item different from expected Item");
        Assert.assertTrue(actualPriceCheck.contains(expectedPriceCheck), "Actual price different from expected price");


    }
}
