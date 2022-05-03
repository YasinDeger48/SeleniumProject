package com.cydeo.test.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day03_T02 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://login1.nextbasecrm.com/");
        WebElement loginCheckBoxLabel = driver.findElement(By.className("login-item-checkbox-label"));
        String expectedText = "Remember me on this computer";
        String actualText = loginCheckBoxLabel.getText();

        if(expectedText.equals(actualText)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }

        WebElement forgotPass = driver.findElement(By.className("login-link-forgot-pass"));
        String currentPassText = forgotPass.getText();
        String expectedPassText = "Forgot your password?";

        if(currentPassText.equals(expectedPassText)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }

        WebElement forgotPass2 = driver.findElement(By.className("login-link-forgot-pass"));
        String actualValue = forgotPass2.getAttribute("href");
        String expectedValue = "forgot_password=yes";

        if(actualValue.contains(expectedValue)) {
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }

        driver.quit();
        }


}
