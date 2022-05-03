package com.cydeo.test.day02_LocatorsAndFindElement.morePractices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_BackAndForth {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");

        WebElement gmailLink = driver.findElement(By.className("gb_d"));
        gmailLink.click();

        String gmailTitle = driver.getTitle();
        String expectedTitle = "Gmail";
        if(gmailTitle.startsWith(expectedTitle)){
            System.out.println("title passed- gmail "+gmailTitle);
        }else{
            System.out.println("title failed - gmail "+gmailTitle);
        }

        driver.navigate().back();

        String googleTitle = driver.getTitle();
        String googleExpectedTitle = "Google";

        if(googleTitle.equals(googleExpectedTitle)){
            System.out.println("title passed - google");
        }else{
            System.out.println("title failed - google");
        }

        driver.quit();

    }
}
