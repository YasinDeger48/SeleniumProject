package com.cydeo.oscarReview.review04;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase2 {
    WebDriver driver;
    List<WebElement> totalNames;

    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver("Chrome");
    }

    @AfterClass
    public void finished(){
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void goToSite(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
    }

    @Test (priority = 2)
    public void loginSite(){
        WebElement userName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        userName.sendKeys("Tester");
        WebElement passWord = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
        passWord.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_login_button\"]"));
        loginButton.click();
    }

    @Test(priority = 3)
    public void selectCheckBox(){
        WebElement willDelete = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_orderGrid_ctl04_OrderSelector']"));
        willDelete.click();
        BrowserUtils.sleep(2);
    }

    @Test(priority = 4)
    public void deleteLine(){
        totalNames = driver.findElements(By.xpath("//table//table//tr//td[2]"));
        WebElement Delete = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_btnDelete']"));

        Delete.click();
        BrowserUtils.sleep(1);

    }

    @Test (priority = 5)
    public void verify(){

        int actualSize = (driver.findElements(By.xpath("//table//table//tr//td[2]"))).size();
        int expectedSize = totalNames.size();

        Assert.assertFalse(actualSize == expectedSize , "Element removed from the list");


    }

    @Test(priority = 6)
    public void secondTabTitle(){
        WebElement viewAllProductsTab = driver.findElement(By.xpath("//ul[@id='ctl00_menu']//li[2]"));
        viewAllProductsTab.click();
        String expectedTitle = "View all products";
        viewAllProductsTab = driver.findElement(By.xpath("//ul[@id='ctl00_menu']//li[2]"));
        String actualTitle = viewAllProductsTab.getText();
        Assert.assertEquals(actualTitle,expectedTitle,"View all products tab title is not matching");
    }

    @Test(priority = 7)
    public void checkTable(){
        WebElement MyMoneyText = driver.findElement(By.xpath("//table[@class='ProductsTable']//tbody//tr[2]//td[1]"));
        WebElement tenPercentText = driver.findElement(By.xpath("//table[@class='ProductsTable']//tbody//tr[4]//td[3]"));
        String expectedTextMoney = "MyMoney";
        String actualTextMoney = MyMoneyText.getText();
        String expectedTextPercent = "10%";
        String actualTextPercent = tenPercentText.getText();

        Assert.assertEquals(actualTextMoney.equals(expectedTextMoney), actualTextPercent.equals(expectedTextPercent),"Table data is not verified" );

    }

    @Test(priority = 7)
    public void thirdTabTitle(){
        WebElement orderTab = driver.findElement(By.linkText("Order"));
        orderTab.click();
        orderTab = driver.findElement(By.linkText("Order"));
        String actualText = orderTab.getText();
        String expectedText = "Order";
        Assert.assertEquals(actualText, expectedText);

    }

    @Test(priority = 8)
    public void productInformationCheck(){

        Select select = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        List<WebElement> options = select.getOptions();
        select.selectByValue("ScreenSaver");
        BrowserUtils.sleep(2);
        WebElement quantity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));

        quantity.sendKeys("10");
        BrowserUtils.sleep(2);

        double quantityValue = Double.parseDouble(quantity.getAttribute("value"));

        WebElement pricePerUnit = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice"));
        double pricePerUnitValue = Double.parseDouble(pricePerUnit.getAttribute("value"));

        double expectedValue = (quantityValue * pricePerUnitValue) *0.9;

        WebElement calculateButton = driver.findElement(By.xpath("(//input[@class='btn_dark'])[1]"));
        calculateButton.click();
        BrowserUtils.sleep(2);


        WebElement total = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal"));
        double totalValue = Double.parseDouble(total.getAttribute("value"));

        Assert.assertEquals(totalValue,expectedValue);

    }

    @Test(priority = 9)
    public void adressVerification(){

    }



}
