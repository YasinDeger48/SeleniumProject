package com.cydeo.test.day02_LocatorsAndFindElement.morePractices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_Etsy {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.etsy.com/");
        Thread.sleep(1500);


        WebElement searchBar = driver.findElement(By.name("search_query"));
        searchBar.sendKeys("wooden spoon" + Keys.ENTER);
        Thread.sleep(1500);

        String currentTitle = driver.getTitle();
        String expectedTitle = "Wooden spoon | Etsy";
        if(currentTitle.equals(expectedTitle)){
            System.out.println("title verification passed");
        }else{
            System.out.println("title verification failed");
        }

        driver.quit();

    }
}
