package com.cydeo.test.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day03_T05 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        WebElement input = driver.findElement(By.className("login-inp"));

        input.sendKeys("incorrect username" + Keys.ENTER);

        WebElement resetClick = driver.findElement(By.className("login-btn"));

        resetClick.click();

        String expectedLabel = "Login or E-mail not found";

        WebElement response = driver.findElement(By.className("errortext"));
        String actualText = response.getText();

        if(expectedLabel.equals(actualText)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }

        driver.quit();




    }
}
