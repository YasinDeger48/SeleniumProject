package com.cydeo.oscarReview.review05.alertTask;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Alert_Task2 {

    WebDriver driver;

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void alertTest(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.demoblaze.com/index.html");


        //Use the utility class invoked with the link Strings
        ReviewUtils.getLink(driver, "Laptops");
        ReviewUtils.wait(1);

        ReviewUtils.getLink(driver, "Sony vaio i5");
        ReviewUtils.wait(1);


        ReviewUtils.getLink(driver, "Add to cart");
        ReviewUtils.wait(1);

        Alert alert = driver.switchTo().alert();

        ReviewUtils.wait(1);
        alert.accept();

    }

}
