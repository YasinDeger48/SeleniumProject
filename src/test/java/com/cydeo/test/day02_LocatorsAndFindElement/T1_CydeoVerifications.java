package com.cydeo.test.day02_LocatorsAndFindElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerifications {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com");
      //  driver.navigate().to("https://practice.cydeo.com");

       //Expected = "cydeo"

        String expectedURL = "cydeo";
        String actualURL = driver.getCurrentUrl();

        if(actualURL.contains(expectedURL)){
            System.out.println("URL verification PASSED");
        }else{
            System.out.println("URL verification FAILED");
        }

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if(actualTitle.contains(expectedTitle)){
            System.out.println("Title verification PASSED");
        }else{
            System.out.println("Title verification FAILED");
        }





        driver.quit();
    }
}
