package com.cydeo.test.day02_LocatorsAndFindElement;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

public class T4_LibraryVerification {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://library2.cybertekschool.com/login.html");
        Thread.sleep(2000);

        //WebElement email = driver.findElement(By.className("form-control"));
        WebElement email = driver.findElement(By.id("inputEmail"));
        Thread.sleep(1000);
        email.sendKeys("incorrect@email.com");

        WebElement password = driver.findElement(By.id("inputPassword"));
        Thread.sleep(1000);
        password.sendKeys("incorrect password");

        WebElement clickButton = driver.findElement(By.tagName("button"));
        Thread.sleep(1000);
        clickButton.click();

        WebElement isShow = driver.findElement(By.cssSelector("#login-form > div:nth-child(2) > div"));

        BrowserUtils.sleep(2);

        if(isShow.isDisplayed()){
            System.out.println("Message is displayed on the screen");
        }else{
            System.out.println("Message is not displayed on the screen");
        }



        Thread.sleep(1500);


        driver.quit();

    }
}
