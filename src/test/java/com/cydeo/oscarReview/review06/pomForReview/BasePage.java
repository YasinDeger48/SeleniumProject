package com.cydeo.oscarReview.review06.pomForReview;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //second step common locators and methods for the application
    /*@FindBy(xpath = "//*[@id='header']//ul/li")
    public WebElement headerLinks;*/

    @FindBy(xpath = "//a[contains(.,'Contact us')]")
    public WebElement contactUs;

    public WebElement getHeaderLink(String str){
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[contains(.,'"+str+"')]"));
        return element;
    }

    @FindBy(tagName = "a")
    public List<WebElement> links;



}
