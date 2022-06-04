package com.cydeo.test.day05_Intro_Dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T4_SimpleDropDown {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.out.println("Test is starting");
         driver = WebDriverFactory.getDriver("chrome");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");

    }

    @AfterMethod
    public void finish(){
        System.out.println("test finished");
        driver.quit();
    }

    @Test
    public void simpleDropDownTest(){

        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        WebElement currentlySelectedOptions = dropdown.getFirstSelectedOption();

        String actualSimpleDropDownText = currentlySelectedOptions.getText();

        String expectedSimpleDropDownText = "Please select an option";

        Assert.assertEquals(actualSimpleDropDownText,expectedSimpleDropDownText);
        List<WebElement> options = dropdown.getOptions();

        //System.out.println(options.get(1).getText());

        Select stateDropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        WebElement dropDownState = stateDropDown.getFirstSelectedOption();

        String actualDropDownState = dropDownState.getText();
        String expectedDropDownState = "Select a State";

        Assert.assertEquals(actualDropDownState,expectedDropDownState);

    }


}
//table[@id='table1']//tbody//tr[4]//td/../td[1]