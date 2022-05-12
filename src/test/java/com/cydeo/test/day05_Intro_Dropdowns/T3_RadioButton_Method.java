package com.cydeo.test.day05_Intro_Dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T3_RadioButton_Method {

    static WebDriver driver;

    public static void main(String[] args) {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/radio_buttons");


        clickAndVerifyRadioButton(driver, "sport", "hockey");

        clickAndVerifyRadioButton(driver, "sport", "football");

        clickAndVerifyRadioButton(driver, "color", "yellow");


        driver.quit();

    }



    private static void clickAndVerifyRadioButton(WebDriver driver, String nameAttribute, String ID) {

        List<WebElement> radioButtons = driver.findElements(By.name(nameAttribute));

        for (WebElement each : radioButtons) {

            String eachID = each.getAttribute("id");

            if (eachID.equals(ID)) {
                each.click();
                break;
            }

        }

        System.out.println("all test passed");

    }

}
