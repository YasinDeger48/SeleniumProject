package com.cydeo.test.day02_LocatorsAndFindElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_LinkText_Practice {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // go to "https://practice.cydeo.com"

        driver.get("https://practice.cydeo.com");

        //click the A/B Testing

       // driver.findElement(By.linkText("A/B Testing"));  //find the element then click it.
        //driver.findElement(By.linkText("A/B Testing")).click();
        //more usable version
        WebElement abTestLink = driver.findElement(By.linkText("A/B Testing"));
        abTestLink.click();
        Thread.sleep(1500);

        driver.navigate().back();
        Thread.sleep(1500);


        WebElement addRemoveElements = driver.findElement(By.linkText("Add/Remove Elements"));
        addRemoveElements.click();
        Thread.sleep(1500);

        driver.navigate().back();
        Thread.sleep(1500);


        WebElement autocomplete = driver.findElement(By.linkText("Autocomplete"));
        autocomplete.click();
        Thread.sleep(1500);

        driver.navigate().back();
        Thread.sleep(1500);


        WebElement basic_auth = driver.findElement(By.linkText("Basic Auth"));
        basic_auth.click();
        Thread.sleep(1500);

        driver.navigate().back();
        Thread.sleep(1500);


        WebElement broken_images = driver.findElement(By.linkText("Broken Images"));
        broken_images.click();
        Thread.sleep(1500);

        driver.navigate().back();
        Thread.sleep(1500);


        WebElement challenging_dom = driver.findElement(By.linkText("Challenging DOM"));
        challenging_dom.click();
        Thread.sleep(1500);

        driver.navigate().back();
        Thread.sleep(1500);


        WebElement checkboxes = driver.findElement(By.linkText("Checkboxes"));
        checkboxes.click();
        Thread.sleep(1500);











        //back to the homepage using back()

        driver.navigate().back();
        Thread.sleep(2000);

        String currentTitle = driver.getTitle();
        String actualTitle = "Practice";

        if(currentTitle.contains(actualTitle)){
            System.out.println("Title verification test PASSED");
        }else{
            System.out.println("Title verification test FAILED");
        }

        driver.quit();
    }
}
