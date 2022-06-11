package com.cydeo.oscarReview.review06.pomForReview;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SmartBearPage {

    public SmartBearPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement userName;

    @FindBy(id = "ctl00_MainContent_password")
    public WebElement passWord;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement loginButton;

    @FindBy(xpath = "(//ul[@id='ctl00_menu']//li)[3]")
    public WebElement orderLink;

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement dropdown;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantity;

    @FindBy(xpath = "//input[@value='Calculate']")
    public WebElement calculateButton;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtTotal")
    public WebElement total;
}
