package com.cydeo.exampleYasin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleExample {


    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");

        WebElement inputElement = driver.findElement(By.name("q"));

        inputElement.sendKeys("Furkan");

        WebElement oturum_açın = driver.findElement(By.linkText("Oturum açın"));

        oturum_açın.click();

        WebElement email = driver.findElement(By.className("whsOnd"));

        email.sendKeys("yasin.deger48@gmail.com");

        WebElement buttonIleri = driver.findElement(By.className("VfPpkd-vQzf8d"));

        buttonIleri.click();



        Thread.sleep(2500);


        driver.quit();


    }
}
