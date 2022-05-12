package com.cydeo.myExamples;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class GoogleFirefox {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("Firefox");

        driver.get("https://www.google.com");

        driver.manage().window().maximize();

        driver.quit();

    }
}
