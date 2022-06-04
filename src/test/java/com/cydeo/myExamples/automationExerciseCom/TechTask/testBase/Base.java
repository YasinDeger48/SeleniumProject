package com.cydeo.myExamples.automationExerciseCom.TechTask.testBase;


import com.cydeo.myExamples.automationExerciseCom.TechTask.util.Driver;
import com.cydeo.test.day08_WebTableContinue_Properties_ConfigurationReader.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
