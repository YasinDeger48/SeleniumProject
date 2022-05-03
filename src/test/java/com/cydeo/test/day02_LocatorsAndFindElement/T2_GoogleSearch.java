package com.cydeo.test.day02_LocatorsAndFindElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_GoogleSearch {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://www.google.com");

        WebElement searchSide = driver.findElement(By.name("q"));
       // searchSide.sendKeys("apple"+ Keys.ENTER);
        //KEYS ENTER İLE DE GİRİŞ YAPABİLİRİZ

        searchSide.sendKeys("apple");

        Thread.sleep(1500);

        WebElement searchEnter = driver.findElement(By.name("btnK"));
        searchEnter.click();
        Thread.sleep(2500);

        String currentTitle = driver.getTitle();
        String actualTitle = "apple";

        if(currentTitle.startsWith(actualTitle)){
            System.out.println("Title verification PASSED");
        }else{
            System.out.println("Title verification FAILED");
        }



        driver.quit();
    }
}
