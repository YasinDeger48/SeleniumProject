package com.cydeo.oscarReview.review04;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase1 {
    WebDriver driver;

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

    @Test (priority = 1)
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

    @Test (priority = 3)
    public void clickCheckAll(){
        WebElement checkAll = driver.findElement(By.id("ctl00_MainContent_btnCheckAll"));
        checkAll.click();
    }

    @Test (priority = 5)
    public void clickUnCheckAll(){
        WebElement unCheckAll = driver.findElement(By.id("ctl00_MainContent_btnUncheckAll"));
        unCheckAll.click();
    }
    @Test(priority = 4)
    public void checkAll(){
        List<WebElement> checkboxs = driver.findElements(By.tagName("checkbox"));
        for (WebElement eachCheckbox : checkboxs) {
            if(!(eachCheckbox.isSelected())){
                System.out.println("Error! Some CheckBoxes are already unchecked");
            }
        }

        System.out.println("All Checkboxes are checked");
    }
    @Test(priority = 6)
    public void unCheckAll(){
        List<WebElement> checkboxs = driver.findElements(By.tagName("checkbox"));
        for (WebElement eachCheckbox : checkboxs) {
            if(eachCheckbox.isSelected()){
                System.out.println("Error! Some CheckBoxes are checked");
            }
        }

        System.out.println("All Checkboxes are unchecked");

    }
}
