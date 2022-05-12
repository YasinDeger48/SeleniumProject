package com.cydeo.test.day04_CheckBox_Radio.task;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T6 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/abtest");

        //WebElement cydeoText = driver.findElement(By.xpath("//div[@id='page-footer']/div/div/a"));
        WebElement cydeoText = driver.findElement(By.xpath("//a[@href='https://cydeo.com/']"));

        System.out.println("cydeoText.isDisplayed() = " + cydeoText.isDisplayed());

        driver.navigate().refresh();

/*


        WebElement cydeoText2 = driver.findElement(By.xpath("//div[@id='page-footer']/div/div/a"));
        System.out.println("cydeoText2.isDisplayed() = " + cydeoText2.isDisplayed());
*/

        try{
            System.out.println("cydeoText.isDisplayed() = " + cydeoText.isDisplayed());

        }catch (StaleElementReferenceException e){
            e.printStackTrace();
            System.out.println("Code crashed");
        }



        driver.quit();


    }
}
