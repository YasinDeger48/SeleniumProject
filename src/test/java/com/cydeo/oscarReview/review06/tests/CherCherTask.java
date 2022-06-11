package com.cydeo.oscarReview.review06.tests;

import com.cydeo.oscarReview.review06.pomForReview.CherCherHomepage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CherCherTask {
    CherCherHomepage cch;
    WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        cch = new CherCherHomepage();
        wait = new WebDriverWait(Driver.getDriver(),10);
    }


    @AfterMethod
    public void tearDown(){
        BrowserUtils.sleep(2);
        Driver.stopSession();
    }
    @Test
    public void cher_cher_test(){

        /*Task1:
    1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
    2. Click on "Click me, to Open an alert after 5 seconds"
    3. Explicitly wait until alert is present
    4. Then handle the Javascript alert*/
        cch.alertButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }

    @Test
    public void change_text_test(){

        cch.changeText.click();
        wait.until(ExpectedConditions.textToBe(By.id("h2"),"Selenium Webdriver"));
        String expectedText = "Selenium Webdriver";
        String actualResult = cch.text.getText();
        Assert.assertTrue(actualResult.equals(expectedText),"text is not matching after clicking");


    }

    @Test
    public void display_button_test(){
        cch.displayButtonButton.click();
        wait.until(ExpectedConditions.visibilityOf(cch.enableButton));

    }

    @Test
    public void enable_button_test(){

        cch.enableButtonButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(cch.disableButton));

    }

    @Test
    public void enable_checkbox_test(){
        cch.checkboxButton.click();
        wait.until(ExpectedConditions.elementSelectionStateToBe(cch.checkBox,true));
        Assert.assertTrue(cch.checkBox.isSelected(),"checkbox is not checked");


    }

}
