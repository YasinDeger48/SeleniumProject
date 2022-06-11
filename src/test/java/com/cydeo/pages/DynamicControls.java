package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControls {

    public DynamicControls(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='Remove']")
    public WebElement removeButton;


    @FindBy(id = "loading")
    public WebElement loadingBar;

    @FindBy(id = "checkbox")
    public WebElement checkbox;

    @FindBy(id = "message")
    public WebElement itsGoneMessage;

    @FindBy(xpath = "//button[.='Add']")
    public WebElement addButton;

    @FindBy(xpath = "//button[.='Enable']")
    public WebElement enableButton;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement inputBox;

    @FindBy(xpath = "//button[.='Disable']")
    public WebElement disableButton;
}
