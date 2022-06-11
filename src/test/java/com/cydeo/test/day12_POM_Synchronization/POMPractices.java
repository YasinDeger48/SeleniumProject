package com.cydeo.test.day12_POM_Synchronization;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POMPractices {

    LibraryLoginPage libraryLoginPage;

    @BeforeMethod
    public void setUpMethod(){
        Driver.getDriver().get("https://library1.cydeo.com");
        libraryLoginPage = new LibraryLoginPage();

    }

    @Test
    public void required_field_error_message_test(){


        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com

        //Driver.getDriver().get("https://library1.cydeo.com");
        //3- Do not enter any information
        //4- Click to “Sign in” button
        //libraryLoginPage = new LibraryLoginPage();
        libraryLoginPage.signInButton.click();
        //5- Verify expected error is displayed:
        //Expected: This field is required.
        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMessage.isDisplayed());

        //
        //NOTE: FOLLOW POM DESIGN PATTERN

        Driver.stopSession();
    }

    @Test
    public void invalid_email_format_error_message_test(){
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        //Driver.getDriver().get("https://library1.cydeo.com");
        //3- Enter invalid email format
        //4- Verify expected error is displayed:
        //libraryLoginPage = new LibraryLoginPage();

        libraryLoginPage.inputUsername.sendKeys("abc.com", Keys.TAB);
        //Expected: Please enter a valid email address.

        Assert.assertTrue(libraryLoginPage.enterValidEmailErrorMessage.isDisplayed());
        //
        //NOTE: FOLLOW POM DESIGN PATTERN
        //
        Driver.stopSession();
    }

    @Test
    public void library_negative_login_test(){
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        //Driver.getDriver().get("https://library1.cydeo.com");
        //3- Enter incorrect username or incorrect password
        //4- Verify title expected error is displayed:
        //libraryLoginPage = new LibraryLoginPage();
        libraryLoginPage.inputUsername.sendKeys("abc@abc.com");
        libraryLoginPage.inputPassword.sendKeys("abcabc123");
        libraryLoginPage.signInButton.click();
        Assert.assertTrue(libraryLoginPage.wrongEmailOrPasswordErrorMessage.isDisplayed());
        //Expected: Sorry, Wrong Email or Password

        Driver.stopSession();
    }


}
