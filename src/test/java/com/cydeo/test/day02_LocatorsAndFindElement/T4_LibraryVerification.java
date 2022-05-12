package com.cydeo.test.day02_LocatorsAndFindElement;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_LibraryVerification {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://library2.cybertekschool.com/login.html");
        Thread.sleep(2000);

        WebElement email = driver.findElement(By.className("form-control"));
        Thread.sleep(1000);
        email.sendKeys("incorrect@email.com");

        WebElement password = driver.findElement(By.id("inputPassword"));
        Thread.sleep(1000);
        password.sendKeys("incorrect password");

        WebElement clickButton = driver.findElement(By.tagName("button"));
        Thread.sleep(1000);
        clickButton.click();

        WebElement isShow = driver.findElement(By.cssSelector("#login-form > div:nth-child(2) > div"));

        HandleWait.wait(2);

        if(isShow.isDisplayed()){
            System.out.println("Message is displayed on the screen");
        }else{
            System.out.println("Message is not displayed on the screen");
        }



        Thread.sleep(1500);


        driver.quit();

    }
}
