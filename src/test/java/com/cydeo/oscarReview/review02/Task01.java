package com.cydeo.oscarReview.review02;

import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.Utilities;

public class Task01 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/forgot_password");
        Thread.sleep(2000);

        WebElement email = driver.findElement(By.name("email"));
        String mail = "yasin.deger48@gmail.com";
        email.sendKeys(mail);
        Thread.sleep(2500);

        WebElement checkInput = driver.findElement(By.name("email"));

        if(checkInput.isSelected()){
            System.out.println("correct");
        }else{
            System.out.println("false");
        }


        driver.quit();


    }
}
