package com.cydeo.test.day04_CheckBox_Radio.task;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class T3 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/multiple_buttons");

        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        WebElement textResult = driver.findElement(By.xpath("//p[@id='result']"));
        BrowserUtils.sleep(2);
        button1.click();

        String expectedResult = "Clicked on button one!";
        String actualResult = textResult.getText();
        String result = (actualResult.equals(expectedResult) && textResult.isDisplayed())? "Text is verified" : "Text is not verified";
        BrowserUtils.sleep(2);
        System.out.println(result);

        driver.quit();

    }
}
