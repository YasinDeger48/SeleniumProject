package com.cydeo.test.day05_Intro_Dropdowns;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T2_RadioButtonHandling {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/radio_buttons");

        WebElement hockeyElement = driver.findElement(By.xpath("//input[@id='hockey']"));
        HandleWait.wait(2);
        hockeyElement.click();

        if (hockeyElement.isSelected()) {
            System.out.println("Button is selected. Verification passed!");
        } else {
            System.out.println("Button is not selected. Verification failed!");


        }


        driver.quit();
    }
}
