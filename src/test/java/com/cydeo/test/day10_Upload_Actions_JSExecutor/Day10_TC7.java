package com.cydeo.test.day10_Upload_Actions_JSExecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class Day10_TC7 {


    @Test
    public void scroll_JavaExecutor(){

        Driver.getDriver().get("https://practice.cydeo.com/large ");

       // ((JavascriptExecutor)Driver.getDriver()).executeScript("window.scroll(0,document.body.offsetHeight)");

        ((JavascriptExecutor)Driver.getDriver()).executeScript("");

        Driver.wait(2);

        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true)",Driver.getDriver().findElement(By.id("page-footer")));


        Driver.wait(2);
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true)",Driver.getDriver().findElement(By.xpath("//a[@class='nav-link']")));

        Driver.wait(2);


        Driver.stopSession();
    }
}
