package com.cydeo.test.day04_CheckBox_Radio.task;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T4 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/abtest");

        WebElement homeLink = driver.findElement(By.xpath("//a[@href='/']"));
        WebElement cydeoLink = driver.findElement(By.xpath("//a[@href='https://cydeo.com/']"));

        //number of links

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("links number = " + links.size());

        for (WebElement eachlink : links) {
            System.out.println(eachlink.getText() + " : " + eachlink.getAttribute("href"));
        }

        driver.quit();


    }
}
