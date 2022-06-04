package com.cydeo.oscarReview.review06;

import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class SmartBearTask {




    @Test
    public void smart_bear(){
        // 1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx

        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //3. Enter username: “Tester”
        //4. Enter password: “test”
        //5. Click on Login button

        WebElement username = Driver.getDriver().findElement(By.id("ctl00_MainContent_username"));
        username.sendKeys("Tester", Keys.TAB,"test",Keys.ENTER);


        //6. Click on Order

        Driver.getDriver().findElement(By.xpath("//ul[@id='ctl00_menu']//li[3]//a")).click();
        //7. Select familyAlbum from product, set quantity to 2
        Select select = new Select(Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        select.selectByValue("FamilyAlbum");
        WebElement quantityElement = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantityElement.clear();
        quantityElement.sendKeys("2");
        //8. Click to “Calculate” button
        Driver.getDriver().findElement(By.cssSelector("input[value='Calculate']")).click();
        //9. Fill address Info with JavaFaker//Generate: name, street, city, state, zip code
        Faker faker = new Faker(new Locale("tr"));
        WebElement customerName = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        customerName.sendKeys(faker.name().fullName(),Keys.TAB, faker.address().streetAddress(),Keys.TAB,
                faker.address().city(),Keys.TAB,faker.address().state(),Keys.TAB, faker.address().zipCode().replaceAll("-",""));


        //10. Click on “visa” radio button
        Driver.getDriver().findElement(By.xpath("//input[@value='Visa']")).click();
        //11. Generate card number using JavaFaker
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(faker.business().creditCardNumber().replaceAll("-",""),
                Keys.TAB,faker.business().creditCardExpiry().substring(2).replaceAll("-","/"));

        //12. Click on “Process”
        Driver.getDriver().findElement(By.xpath("//div[@class='buttons_process']//a")).click();
        //13. Verify success message “New order has been successfully added.”

        WebElement element = Driver.getDriver().findElement(By.xpath("//div[@class='buttons_process']//strong"));
        String actualTitle = element.getText();
        String expectedTitle = "New order has been successfully added.";
        Assert.assertTrue(actualTitle.equals(expectedTitle),"titles are not matching");

        Driver.getDriver().quit();
    }




}
