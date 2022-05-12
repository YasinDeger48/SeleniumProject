package com.cydeo.test.day04_CheckBox_Radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task4_FindElement {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        //Providing extra wait time
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/abtest");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        // System.out.println(allLinks.size());

        for (WebElement eachLink : allLinks) {
            System.out.println(eachLink.getText() + " : "+ eachLink.getAttribute("href"));
        }


        driver.quit();





    }
}
