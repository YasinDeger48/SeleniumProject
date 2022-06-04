package com.cydeo.utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReviewUtils {

    public static void wait(int second) {

        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // will be used  in demoblaze application, to navigate to different links at the page.


    public static void getLink(WebDriver driver, String link) {
        driver.findElement(By.partialLinkText(link)).click();
        wait(1);
    }


    public static double addProduct(WebDriver driver, String category, String product) {
        getLink(driver, category); // click on category
        getLink(driver, product); // click on product
        // Let's get product's price
        String priceText = driver.findElement(By.tagName("h3")).getText();
        double price = Double.parseDouble(priceText.substring(1));

        getLink(driver, "Add to cart");
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return price;
    }


}
