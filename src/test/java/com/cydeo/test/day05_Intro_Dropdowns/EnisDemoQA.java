package com.cydeo.test.day05_Intro_Dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EnisDemoQA {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/tool-tips");
    }

    @AfterClass
    public void finish() {
        driver.quit();
    }

    @Test
    public void enis(){
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//button[@id='toolTipButton']"));
        builder.moveToElement(element).build().perform();
       // WebElement hideElement = driver.findElement(By.cssSelector("div#buttonToolTip.fade.show.tooltip.bs-tooltip-right"));
        WebElement hideElement = driver.findElement(By.xpath("//div[@role='tooltip']"));
        String expectedText = "You hovered over the Button";
        String actualText = hideElement.getText();
        Assert.assertEquals(actualText,expectedText);
        System.out.println("Actual Text: "+ actualText);


    }
}
