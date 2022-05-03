package com.cydeo.test.day02_LocatorsAndFindElement.morePractices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_ZeroBank {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.get("http://zero.webappsecurity.com/login.html");

        String expectedTitle = "Log in to ZeroBank";
        WebElement actualTitleElement = driver.findElement(By.xpath("//h3[1]"));
        String actualTitle = actualTitleElement.getText();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("title verification passed");
        }else{
            System.out.println("title verification failed");
        }

        driver.quit();




    }
}
