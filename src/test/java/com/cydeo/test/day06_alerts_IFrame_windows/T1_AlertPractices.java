package com.cydeo.test.day06_alerts_IFrame_windows;

import com.cydeo.utilities.Wait;
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

public class T1_AlertPractices {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/javascript_alerts");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void alert_test1(){

        WebElement informationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        //WebElement informationAlertButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        informationAlertButton.click();
        Wait.wait(1);

        //Click the OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Wait.wait(1);

        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
        boolean resultTextIsDisplayed = resultText.isDisplayed();
        Assert.assertTrue(resultTextIsDisplayed,"Result text is not displayed on the web page");
        String expectedText = "You successfully clicked an alert";
        String actualText = resultText.getText();
        Assert.assertEquals(actualText,expectedText,"result text is not matching with the expected text");
    }

    @Test
    public void alert_test2(){
        WebElement confirmationAlertButton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        confirmationAlertButton.click();
        Wait.wait(1);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Wait.wait(1);
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
        String expectedTextCon = "You clicked: Ok";
        String actualTextCon = resultText.getText();
        Assert.assertEquals(actualTextCon,expectedTextCon,"Result is not matching");
        confirmationAlertButton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        confirmationAlertButton.click();
        Wait.wait(1);
        alert.dismiss();
        Wait.wait(1);
        resultText = driver.findElement(By.xpath("//p[@id='result']"));
        String expectedTextConDis = "You clicked: Cancel";
        String actualTextConDis = resultText.getText();
        Assert.assertEquals(actualTextConDis,expectedTextConDis,"Result is not matching");
    }

    @Test
    public void alert_test3(){
        WebElement confirmationAlertButton = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        confirmationAlertButton.click();
        Wait.wait(1);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        Wait.wait(2);
        alert.accept();
        Wait.wait(1);
    }
}
