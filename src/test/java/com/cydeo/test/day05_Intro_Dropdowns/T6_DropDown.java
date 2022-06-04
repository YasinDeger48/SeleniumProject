package com.cydeo.test.day05_Intro_Dropdowns;

import com.cydeo.utilities.Wait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class T6_DropDown {
    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com//dropdown");
    }

    @AfterClass
    public void finish() {
        driver.quit();
    }

    @Test
    public void selectYear() {

        Select year = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        year.selectByVisibleText("1923");
        Wait.wait(2);

    }

    @Test
    public void selectMonth() {

        Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        month.selectByValue("11");
        Wait.wait(2);

    }

    @Test
    public void selectDay() {

        Select day = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        day.selectByIndex(1);
        Wait.wait(2);

    }

    @Test
    public void Verifying() {

        Select year = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select day = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        year.selectByVisibleText("1923");
        month.selectByValue("11");
        day.selectByIndex(0);

        if (year.getFirstSelectedOption().getText().equals("1923") && month.getFirstSelectedOption().getText().equals("December") &&
                day.getFirstSelectedOption().getText().equals("1")) {
            System.out.println("Date verifying PASSED!");
        } else {
            System.out.println("Date verifying FAILED!");
        }
        Wait.wait(2);
    }


}
