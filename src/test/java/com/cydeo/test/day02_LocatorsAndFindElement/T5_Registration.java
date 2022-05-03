package com.cydeo.test.day02_LocatorsAndFindElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_Registration {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/registration_form");
        Thread.sleep(1500);

        String expectedTitle = "Registration form";
        WebElement actualTitle = driver.findElement(By.xpath("//h2"));
        boolean hasSameTitle = actualTitle.getText().equals(expectedTitle);

        if(hasSameTitle){
            System.out.println("Title verification PASSED");
        }else {
            System.out.println("Title verification FAILED");
        }

        WebElement firstNameElement = driver.findElement(By.name("firstname"));
        System.out.println(firstNameElement.getAttribute("placeholder"));
        Thread.sleep(1500);

        driver.quit();

    }
}
