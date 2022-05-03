package com.cydeo.test.day02_LocatorsAndFindElement.morePractices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_Practice_CYDEO {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://practice.cydeo.com/inputs");

        WebElement homeLink = driver.findElement(By.className("nav-link"));

        homeLink.click();

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("title verification passed");
        }else{
            System.out.println("title verification failed");
        }


        driver.quit();
    }
}
