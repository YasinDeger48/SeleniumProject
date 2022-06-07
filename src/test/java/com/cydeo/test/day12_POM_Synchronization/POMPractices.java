package com.cydeo.test.day12_POM_Synchronization;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.pages.PracticeDynamicsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POMPractices {

    @Test
    public void required_field_error_message_test(){


        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com

        Driver.getDriver().get("https://library1.cydeo.com");
        //3- Do not enter any information
        //4- Click to “Sign in” button
        LibraryLoginPage libraryLoginPage = new LibraryLoginPage();
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
        Driver.getDriver().get("https://library1.cydeo.com");
        //3- Enter invalid email format
        //4- Verify expected error is displayed:
        LibraryLoginPage libraryLoginPage = new LibraryLoginPage();

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
        Driver.getDriver().get("https://library1.cydeo.com");
        //3- Enter incorrect username or incorrect password
        //4- Verify title expected error is displayed:
        LibraryLoginPage libraryLoginPage = new LibraryLoginPage();
        libraryLoginPage.inputUsername.sendKeys("abc@abc.com");
        libraryLoginPage.inputPassword.sendKeys("abcabc123");
        libraryLoginPage.signInButton.click();
        Assert.assertTrue(libraryLoginPage.wrongEmailOrPasswordErrorMessage.isDisplayed());
        //Expected: Sorry, Wrong Email or Password
        Driver.stopSession();
    }

    @Test
    public void dynamically_loaded_page_elements_7_test(){
        //1. Go to https://practice.cydeo.com/dynamic_loading/7
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");
        //2. Wait until title is “Dynamic title”
        BrowserUtils.sleep(6);
        //3. Assert: Message “Done” is displayed.
        PracticeDynamicsPage practicePage = new PracticeDynamicsPage();
        Assert.assertTrue(practicePage.doneText.isDisplayed());
        //4. Assert: Image is displayed.
        Assert.assertTrue(practicePage.image.isDisplayed());
        //Note: Follow POM
        Driver.stopSession();

    }

    @Test
    public void dynamically_loaded_page_elements_1_test(){
        //1. Go to https://practice.cydeo.com/dynamic_loading/1
        //2. Click to start
        //3. Wait until loading bar disappears
        //4. Assert username inputbox is displayed
        //5. Enter username: tomsmith
        //6. Enter password: incorrectpassword
        //7. Click to Submit button
        //8. Assert “Your password is invalid!” text is displayed.
        //Note: Follow POM Design Pattern
    }
}
