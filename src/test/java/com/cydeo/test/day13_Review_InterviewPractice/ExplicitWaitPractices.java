package com.cydeo.test.day13_Review_InterviewPractice;

import com.cydeo.pages.DynamicControls;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitPractices {

    DynamicControls dynamicControls;

    @BeforeMethod
    public void setUp(){
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        dynamicControls = new DynamicControls();

    }

    @Test
    public void remove_button_test(){
        //3- Click to “Remove” button
        dynamicControls.removeButton.click();
        //4- Wait until “loading bar disappears”
        /*Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // o default haline getir.
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(dynamicControls.loadingBar));*/

        //Yukarıdaki üç satır yerine yazdık bu methodu
        BrowserUtils.waitForInvisibilityOf(dynamicControls.loadingBar);
        //5- Verify:
        //a. Checkbox is not displayed
        try {
            Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            Assert.assertTrue(!dynamicControls.checkbox.isDisplayed());
            Assert.assertFalse(dynamicControls.checkbox.isDisplayed());
        }catch (NoSuchElementException e){
            Assert.assertTrue(true);
        }
        //
        //b. “It’s gone!” message is displayed.
        Assert.assertTrue(dynamicControls.itsGoneMessage.isDisplayed());
        Assert.assertTrue(dynamicControls.itsGoneMessage.getText().equals("It's gone!"));
        //NOTE: FOLLOW POM
        Driver.stopSession();
    }


    @Test
    public void enable_button_test(){

        dynamicControls.enableButton.click();

        BrowserUtils.waitForInvisibilityOf(dynamicControls.loadingBar);

        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        //3- Click to “Enable” button
        //4- Wait until “loading bar disappears”
        //5- Verify:

        //a. Input box is enabled.
        Assert.assertTrue(dynamicControls.inputBox.isEnabled());
        //b. “It’s enabled!” message is displayed.
        Assert.assertTrue(dynamicControls.itsGoneMessage.isDisplayed());
        String expectedMessage = "It's enabled!";
        String actualMessage = dynamicControls.itsGoneMessage.getText();

        Assert.assertTrue(actualMessage.equals(expectedMessage));
        //
        //NOTE: FOLLOW POM
    }
}
