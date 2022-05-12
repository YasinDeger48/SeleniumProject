package com.cydeo.oscarReview.review02;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TaskSony {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.demoblaze.com/index.html");

        driver.manage().window().maximize();
        HandleWait.wait(2);
        WebElement laptopTab = driver.findElement(By.linkText("Laptops"));

        laptopTab.click();
        HandleWait.wait(2);

        WebElement sony_vaio_i5 = driver.findElement(By.linkText("Sony vaio i5"));

        sony_vaio_i5.click();
        HandleWait.wait(2);

        WebElement priceCheck = driver.findElement(By.className("price-container"));

        String priceCheckAttribute = priceCheck.getText();

        int actualPrice = Integer.parseInt(priceCheckAttribute.split(" ")[0].substring(1));
        int expectedPrice = 790;
        if(actualPrice == expectedPrice){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

        driver.quit();


    }
}
