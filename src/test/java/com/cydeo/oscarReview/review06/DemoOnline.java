package com.cydeo.oscarReview.review06;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.Wait;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoOnline {


    @Test
    public void demo_online(){

        //You have to implement the following Web automated checks over our DEMO ONLINE
        //SHOP: https://www.demoblaze.com/index.html
        Driver.getDriver().get("https://www.demoblaze.com/index.html");

        //• Customer navigation through product categories: Phones, Laptops and Monitors
        //• Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.  --- Create a custom method for adding products
        Driver.getDriver().findElement(By.xpath("//a[.='Laptops']")).click();
        Wait.wait(2);
        Driver.getDriver().findElement(By.xpath("(//div[@class='card-block'])//h4//a[1]")).click();
        Driver.getDriver().findElement(By.xpath("//div[@class='row']//a[@href='#']")).click();
        Wait.wait(3);
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

        //• Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation.
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().back();
        Driver.getDriver().findElement(By.xpath("//a[.='Laptops']")).click();
        Wait.wait(2);
        Driver.getDriver().findElement(By.xpath("(//div[@class='card-block']//h4//a)[4]")).click();
        Driver.getDriver().findElement(By.xpath("//div[@class='row']//a[@href='#']")).click();
        Wait.wait(3);
        alert = Driver.getDriver().switchTo().alert();
        alert.accept();

        //• Click on "Place order".
        Driver.getDriver().findElement(By.xpath("//div[@id='navbarExample']//li[4]//a")).click();
        Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-success']")).click();
        //• Fill in all web form fields. ----USE JavaFaker---create a fillForm() custom method
        Faker faker = new Faker();
        Driver.getDriver().findElement(By.id("name")).sendKeys(faker.name().fullName(), Keys.TAB,faker.address().country(),Keys.TAB,faker.address().city(),Keys.TAB,
                faker.business().creditCardNumber(),Keys.TAB,faker.letterify("????"),Keys.TAB,faker.numerify("####"));
        //• Click on "Purchase"
        Wait.wait(2);
        Driver.getDriver().findElement(By.xpath("//button[@onclick='purchaseOrder()']")).click();
        //• Capture and log purchase Id and Amount.
        String capturedInfo = Driver.getDriver().findElement(By.xpath("//p[@class='lead text-muted ']")).getText();
        //• Assert purchase amount equals expected.
        String expectedPrice = "1490";
        Assert.assertTrue(capturedInfo.contains(expectedPrice),"ExpectedAmount couldn't find");
        //• Click on "Ok" */

        Driver.getDriver().findElement(By.xpath("//div[@class='sa-confirm-button-container']")).click();



        Driver.getDriver().quit();
    }


    /*Smartbear software order placing


    You have to implement the following Web automated checks over our DEMO ONLINE
    SHOP: https://www.demoblaze.com/index.html
    • Customer navigation through product categories: Phones, Laptops and Monitors
    • Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.  --- Create a custom method for adding products
    • Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation.
    • Click on "Place order".
    • Fill in all web form fields. ----USE JavaFaker---create a fillForm() custom method
    • Click on "Purchase"
    • Capture and log purchase Id and Amount.
    • Assert purchase amount equals expected.
    • Click on "Ok" */
}
