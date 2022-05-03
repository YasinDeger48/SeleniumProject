package com.cydeo.test.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day03_T03 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://login1.nextbasecrm.com/");

        WebElement loginInButton = driver.findElement(By.className("login-btn"));
        String loginButtonText = loginInButton.getAttribute("value");
        String expectedText = "Log In";
        if(loginButtonText.equals(expectedText)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }

        driver.quit();
    }
}
