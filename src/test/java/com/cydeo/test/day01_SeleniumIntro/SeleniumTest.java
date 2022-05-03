package com.cydeo.test.day01_SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) {

        //1. Setting up the web driver manager
        WebDriverManager.chromedriver().setup();
        //2. Create instance of the chrome driver
        WebDriver driver = new ChromeDriver();
        //3. navigating to google page
        driver.get("https://www.yasindeger.com");
        System.out.println(driver.getTitle());


    }
}
