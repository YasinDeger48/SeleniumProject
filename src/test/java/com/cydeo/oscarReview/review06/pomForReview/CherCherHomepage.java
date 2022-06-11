package com.cydeo.oscarReview.review06.pomForReview;

import com.cydeo.myExamples.automationExerciseCom.TechTask.testBase.Base;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CherCherHomepage {

    public CherCherHomepage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "alert")
    public WebElement alertButton;

    @FindBy(id = "populate-text")
    public WebElement changeText;

    @FindBy(id = "h2")
    public WebElement text;

    @FindBy(id = "display-other-button")
    public WebElement displayButtonButton;

    @FindBy(id = "hidden")
    public WebElement enableButton;

    @FindBy(id = "enable-button")
    public WebElement enableButtonButton;

    @FindBy(id = "disable")
    public WebElement disableButton;

    @FindBy(id = "checkbox")
    public WebElement checkboxButton;

    @FindBy(id = "ch")
    public WebElement checkBox;


}
