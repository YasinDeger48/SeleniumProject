package com.cydeo.test.day04_CheckBox_Radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Task5_CheckBoxes {


    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/checkboxes");

        WebElement checkBox1 = driver.findElement(By.xpath("//input[@name='checkbox1']"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@name='checkbox2']"));

        //checkBox1.click(); //click yaparsak false yerine true olacak.
        //checkBox2.click();  //click yaparak deselect yapmış oluyoruz

        System.out.println(checkBox1.isSelected()); //default hali false
        System.out.println(checkBox2.isSelected()); //default hali true



        driver.quit();

    }
}
