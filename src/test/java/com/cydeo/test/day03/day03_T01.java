package com.cydeo.test.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day03_T01 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://login1.nextbasecrm.com/");

        WebElement input = driver.findElement(By.className("login-inp"));
        input.sendKeys("incorrect");
        Thread.sleep(1500);

        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("incorrect");
        Thread.sleep(1500);

        WebElement submit = driver.findElement(By.className("login-btn"));
        submit.click();

        String expectedContent = "Incorrect login or password";
        WebElement content = driver.findElement(By.className("errortext"));
        String currentText = content.getText();

        if(expectedContent.equals(currentText)){
            System.out.println("pass");
        }else{
            System.out.println("fail");

        driver.quit();

    }}
}
