package com.cydeo.tests.day01_Selenium_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooTitleVerification {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        //driver.get("https://www.yahoo.com");
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(10000);
        driver.manage().window().fullscreen();
        Thread.sleep(5000);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Yahoo";


        if(actualTitle.equals(expectedTitle)){
            System.out.println("Yes title is: "+ actualTitle);
        }else{
            System.out.println("No, title is: "+ actualTitle);
        }

        driver.close();
    }
}
