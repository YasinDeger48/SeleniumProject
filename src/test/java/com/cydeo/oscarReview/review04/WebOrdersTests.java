package com.cydeo.oscarReview.review04;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebOrdersTests {
    WebDriver driver;
    @BeforeMethod
    public void loginWebOrders(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement userName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        userName.sendKeys("Tester");
        WebElement passWord = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
        passWord.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_login_button\"]"));
        loginButton.click();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void checkBoxtest(){
        driver.findElement(By.linkText("Check All")).click();
        List<WebElement> checkbox = driver.findElements(By.tagName("checkbox"));

        for (WebElement element : checkbox) {
            Assert.assertTrue(element.isSelected(), "Checkbox is NOT Checked");
        }
        //driver.findElement(By.linkText("Uncheck All")).click();
        WebElement unCheckAll = driver.findElement(By.id("ctl00_MainContent_btnUncheckAll"));
        unCheckAll.click();

        checkbox = driver.findElements(By.tagName("checkbox"));

        for (WebElement each : checkbox) {
            Assert.assertFalse(each.isSelected(),"Checkbox is STILL Checked");
           //Assert.assertEquals(each.isSelected(), false,"Checkbox is STILL Checked");
        }
        System.out.println(checkbox.size());

    }

    @Test
    public void deletePersonTest(){
        String name ="Bob Feather";
        /*
        Locate the checkBox using the person's Name: Bob Feather
        find with name(child)--> go to parent (whole row) --> down to td of checkbox */
        //td[.='Bob Feather']/../td[1]/input
        //td[.='Bob Feather']/preceding-sibling::*/input
        String locatorOfCheckBoxWithName = "//td[.='"+name+"']/../td[1]/input";
        WebElement checkBox = driver.findElement(By.xpath(locatorOfCheckBoxWithName));
        checkBox.click();

        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();

    }
}
