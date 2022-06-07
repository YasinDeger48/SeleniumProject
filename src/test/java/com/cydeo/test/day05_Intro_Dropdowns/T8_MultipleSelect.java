package com.cydeo.test.day05_Intro_Dropdowns;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T8_MultipleSelect {

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
    public void test1(){
        Select multipleDropDown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        List<WebElement> allOptions = multipleDropDown.getOptions();

        // Select all the options from multiple select dropdown.
        multipleDropDown.selectByIndex(0);
        BrowserUtils.sleep(1);
        multipleDropDown.selectByValue("js");
        BrowserUtils.sleep(1);
        multipleDropDown.selectByVisibleText("C#");
        BrowserUtils.sleep(1);
        multipleDropDown.selectByIndex(3);
        BrowserUtils.sleep(1);
        multipleDropDown.selectByValue("ruby");
        BrowserUtils.sleep(1);
        multipleDropDown.selectByVisibleText("C");
        BrowserUtils.sleep(1);

        // Print out all selected values.
        for (WebElement each : allOptions) {
            if(each.isSelected()){

                System.out.println(each.getText());
            }
        }

        // Deselect all values.
        multipleDropDown.deselectByIndex(0);
        BrowserUtils.sleep(1);
        multipleDropDown.deselectByIndex(1);
        BrowserUtils.sleep(1);
        multipleDropDown.deselectByIndex(2);
        BrowserUtils.sleep(1);
        multipleDropDown.deselectByIndex(3);
        BrowserUtils.sleep(1);
        multipleDropDown.deselectByIndex(4);
        BrowserUtils.sleep(1);
        multipleDropDown.deselectByIndex(5);
        BrowserUtils.sleep(1);



    }
}
