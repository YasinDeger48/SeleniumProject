package com.cydeo.myExamples;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class yusuf1 {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void alert() throws InterruptedException {
        driver.get("https://www.demoblaze.com/index.html");
        WebElement laptopbtn= driver.findElement(By.xpath("//a[.='Laptops']"));
        laptopbtn.click();

        WebElement vaio_i5= driver.findElement(By.xpath("//a[.='Sony vaio i5']"));
        vaio_i5.click();

        WebElement addbtn= driver.findElement(By.xpath("//a[.='Add to cart']"));
        addbtn.click();

        Thread.sleep(3000);
        Alert alert=driver.switchTo().alert();
        alert.accept();

    }


}
