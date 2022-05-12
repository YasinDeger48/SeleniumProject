package com.cydeo.oscarReview.review03;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MethodExample {

    static WebDriver driver;

    public static void main(String[] args) {

       driver =  WebDriverFactory.getDriver("chrome");

       driver.manage().deleteAllCookies();

       driver.get("https://todomvc.com");

       driver.manage().window().maximize();
        WebElement element = driver.findElement(By.xpath("//a[@href = 'examples/polymer/index.html']"));

        element.click();

        String toDoString = "this todo is exciting";

        WebElement element1 = driver.findElement(By.xpath("//input[@id='new-todo']"));
        HandleWait.wait(1);
        element1.sendKeys(toDoString + Keys.ENTER);
        HandleWait.wait(1);



        //driver.navigate().back();
        HandleWait.wait(2);

        //getTab("JavaScript");
        HandleWait.wait(2);

        driver.quit();
    }

    public static void getTab(String tab){

        WebElement element = driver.findElement(By.xpath("//*[.='" + tab + "']"));

        element.click();
    }


}
