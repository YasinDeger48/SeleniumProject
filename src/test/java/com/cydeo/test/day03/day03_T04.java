package com.cydeo.test.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day03_T04 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");
        String expectedButtonText = "Reset password";

        WebElement button = driver.findElement(By.className("login-btn"));
        String actualButtonText = button.getAttribute("value");

        if(expectedButtonText.equals(actualButtonText)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }
        driver.quit();
    }
}
