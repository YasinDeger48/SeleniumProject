package com.cydeo.oscarReview.review05.alertTask;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Alert_Task {
        WebDriver driver;
    /*
    You have to implement the following Web automated checks over our DEMO ONLINE SHOP: https://www.demoblaze.com/index.html
• Customer navigation through product categories: Phones, Laptops and Monitors
• Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
     */

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.demoblaze.com/index.html");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1(){

        WebElement laptopsLink = driver.findElement(By.cssSelector("a[onclick=\"byCat('notebook')\"]"));
        BrowserUtils.sleep(1);
        laptopsLink.click();

        WebElement sonyVaioLink = driver.findElement(By.xpath("//a[.='Sony vaio i5']"));
        String actualSonyText = sonyVaioLink.getText();
        String expectedSonyText = "Sony vaio i5";

        WebElement sonyVaioPrice = driver.findElement(By.xpath("//a[.='Sony vaio i5']/../..//h5"));
        String actualSonyPrice = sonyVaioPrice.getText();
        String expectedSonyPrice = "$790";

        Assert.assertEquals(actualSonyText.equals(expectedSonyText), actualSonyPrice.equals(expectedSonyPrice));
        BrowserUtils.sleep(1);
        sonyVaioLink = driver.findElement(By.xpath("//a[.='Sony vaio i5']"));

        sonyVaioLink.click();

        BrowserUtils.sleep(1);

        WebElement addToCartButton = driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg']"));
        addToCartButton.click();
        BrowserUtils.sleep(2);

        Alert alert = driver.switchTo().alert();
        alert.accept();



    }

}
