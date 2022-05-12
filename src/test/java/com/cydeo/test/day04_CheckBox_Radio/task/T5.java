package com.cydeo.test.day04_CheckBox_Radio.task;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T5 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cydeo.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//input[@name='checkbox1']"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@name='checkbox2']"));

        System.out.println("checkbox1.isSelected() (false) = " + checkbox1.isSelected());
        System.out.println("checkbox2.isSelected() (true) = " + checkbox2.isSelected());

        checkbox1.click();
        checkbox2.click();

        System.out.println("checkbox1.isSelected() (true) = " + checkbox1.isSelected());
        System.out.println("checkbox2.isSelected() (false) = " + checkbox2.isSelected());

        driver.quit();
    }
}
