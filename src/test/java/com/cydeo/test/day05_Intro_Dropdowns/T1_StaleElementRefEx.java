package com.cydeo.test.day05_Intro_Dropdowns;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class T1_StaleElementRefEx {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/add_remove_elements/");


        WebElement addButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        BrowserUtils.sleep(2);
        addButton.click();

        WebElement deleteButton = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));

        System.out.println("deleteButton.isDisplayed(1) = " + deleteButton.isDisplayed());

        deleteButton.click();
        // WebElement deleteButton2 = driver.findElement(By.xpath("//button[.='Delete']"));


        try {
            System.out.println("deleteButton.isDisplayed(2) = " + deleteButton.isDisplayed());

        } catch (StaleElementReferenceException e) {
            System.out.println("---> StaleElementReferenceException exception is thrown");
            System.out.println("---> This means the web element is completely deleted from the page");
            System.out.println("deleteButton.isDisplayed() =  false");
        }

        driver.quit();

    }
}
