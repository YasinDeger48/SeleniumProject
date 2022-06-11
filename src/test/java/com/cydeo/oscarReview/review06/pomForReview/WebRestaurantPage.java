package com.cydeo.oscarReview.review06.pomForReview;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class WebRestaurantPage {

    public WebRestaurantPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "searchval")
    public WebElement searchBar;

    @FindBy(xpath = "//div[@data-testid='productBoxContainer']")
    public WebElement searchedItems;

    @FindBy(xpath = "(//div[@data-testid='productBoxContainer']//input[@type='submit'])")
    public WebElement addToCartButton;

    @FindBy(xpath = "//a[.='View Cart']")
    public WebElement viewCartButton;

    @FindBy(xpath = "//button[@class='emptyCartButton btn btn-mini btn-ui pull-right']")
    public WebElement emptyCartButton;

    @FindBy(xpath = "(//p[@id='empty-cart-body']//..//..//footer/button)[1]")
    public WebElement emptyCartAlertButton;

    @FindBy(xpath = "//p[@class='header-1']")
    public WebElement yourCartIsEmptyMessage;

    @FindBy(xpath = "//a[@data-testid='itemDescription']")
    public WebElement titles;


}
