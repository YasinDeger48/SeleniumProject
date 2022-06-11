package com.cydeo.oscarReview.review06.pomForReview;

import com.cydeo.utilities.ConfigReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends BasePage {

    @FindBy(name = "name")
    public WebElement name;

    @FindBy(name= "email")
    public WebElement email;

    @FindBy(name = "subject")
    public WebElement subject;

    @FindBy(name = "message")
    public WebElement messageBox;

    @FindBy(name = "upload_file")
    public WebElement uploadFile;

    @FindBy(name = "submit")
    public WebElement submitButton;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    public WebElement successMessage;

    @FindBy(xpath = "//div[@id='form-section']/a[contains(.,'Home')]")
    public  WebElement homeButton;



}
