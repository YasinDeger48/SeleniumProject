package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticeDynamicsPage {


    public PracticeDynamicsPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@id='alert']//strong")
    public WebElement doneText;

    @FindBy(xpath = "//img[@class='rounded mx-auto d-block']")
    public WebElement image;
}
