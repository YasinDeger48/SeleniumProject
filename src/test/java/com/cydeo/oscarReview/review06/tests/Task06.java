package com.cydeo.oscarReview.review06.tests;

import com.cydeo.oscarReview.review06.pomForReview.ContactUsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class Task06 {

    @Test
    public void automation_exercise_test6(){
        //Launch browser
        // Navigate to url 'http://automationexercise.com'

        Driver.getDriver().get("http://automationexercise.com");

        // Verify that home page is visible successfully
        // Click on 'Contact Us' button

        ContactUsPage contactUsPage = new ContactUsPage();
        //contactUsPage.contactUs.click();
        contactUsPage.getHeaderLink(" Contact us").click();
        //move the view to submit button

        Actions actions = new Actions(Driver.getDriver());

        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP);
        BrowserUtils.sleep(2);

        actions.moveToElement(contactUsPage.submitButton).perform();
        actions.pause(2000);

        ((JavascriptExecutor)Driver.getDriver()).executeScript("window.scrollBy(0,750)");

        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true)",contactUsPage.submitButton);


        // Enter name, email, subject and message

        Faker faker = new Faker(new Locale("en"));
        contactUsPage.name.sendKeys(faker.name().fullName());
        contactUsPage.email.sendKeys(faker.internet().emailAddress());
        contactUsPage.subject.sendKeys(faker.howIMetYourMother().catchPhrase());
        contactUsPage.messageBox.sendKeys(faker.chuckNorris().fact());
        // Upload file
        String path = "/Users/values/Desktop/crop.jpeg";
        contactUsPage.uploadFile.sendKeys(path);
        // Click 'Submit' button
        contactUsPage.submitButton.click();
        BrowserUtils.sleep(2);
        // Click OK button
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

        // Verify success message 'Success! Your details have been submitted successfully.' is visible

        boolean successMessageDisplayed = contactUsPage.successMessage.isDisplayed();
        Assert.assertTrue(successMessageDisplayed,"Success message can not show on the page");
        // Click 'Home' button and verify that landed to home page successfully

        contactUsPage.homeButton.click();


        Driver.stopSession();
    }
}
