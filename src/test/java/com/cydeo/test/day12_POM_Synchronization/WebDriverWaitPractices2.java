package com.cydeo.test.day12_POM_Synchronization;

import com.cydeo.pages.PracticeDynamicPage1;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriverWaitPractices2 {

    PracticeDynamicPage1 practiceDynamicPage;

    @Test
    public void dynamically_loaded_page_elements_1_test(){
        //1. Go to https://practice.cydeo.com/dynamic_loading/1
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");
        //2. Click to start
        practiceDynamicPage = new PracticeDynamicPage1();
        practiceDynamicPage.startButton.click();


        //3. Wait until loading bar disappears
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

        //wait.until(ExpectedConditions.elementToBeClickable(practiceDynamicPage.inputUserName));
        wait.until(ExpectedConditions.invisibilityOf(practiceDynamicPage.loadingBar));

        //4. Assert username inputbox is displayed
        Assert.assertTrue(practiceDynamicPage.inputUserName.isDisplayed());
        //5. Enter username: tomsmith
        practiceDynamicPage.inputUserName.sendKeys("tomsmith");
        //6. Enter password: incorrectpassword
        practiceDynamicPage.inputPassWord.sendKeys("incorrectpassword");
        //7. Click to Submit button
        practiceDynamicPage.submitButton.click();
        //8. Assert “Your password is invalid!” text is displayed.
        wait.until(ExpectedConditions.visibilityOf(practiceDynamicPage.alertMessage));
        Assert.assertTrue(practiceDynamicPage.alertMessage.isDisplayed());
        //Note: Follow POM Design Pattern

        Driver.stopSession();
    }
}
