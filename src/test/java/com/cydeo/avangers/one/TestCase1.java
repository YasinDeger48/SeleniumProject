package com.cydeo.avangers.one;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase1 {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Ignore
    //@Test
    public void registerUser(){
        WebElement registerUser = driver.findElement(By.linkText("Test Case 1: Register User"));
        registerUser.click();
        test1();

    }

    @Test
    public void test1(){
        driver.get("http://automationexercise.com/");
        Assert.assertTrue(driver.getWindowHandle() != null);
        WebElement signUpLogin = driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        signUpLogin.click();
        WebElement signUpTitleVerify = driver.findElement(By.xpath("//div[@class='signup-form']"));
        Assert.assertEquals(signUpTitleVerify.getText(), "New User Signup!\nSignup");
        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        name.sendKeys("yasin");
        BrowserUtils.sleep(1);
        WebElement mail = driver.findElement(By.xpath("(//input[@name='email'])[2]"));
        mail.sendKeys("yasin@deger.com");
        BrowserUtils.sleep(1);
        WebElement signupButton = driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]"));
        signupButton.click();
        BrowserUtils.sleep(2);
        WebElement titleVerify = driver.findElement(By.xpath("(//div[@class='login-form']//h2)[1]/b"));
        String actualText = titleVerify.getText();
        String expectedText = "ENTER ACCOUNT INFORMATION";
        Assert.assertEquals(actualText,expectedText);
        Assert.assertTrue(titleVerify.isDisplayed());
        //Fill details: Title, Name, Email, Password, Date of birth

        WebElement titlechoose = driver.findElement(By.xpath("//input[@id='id_gender1']"));
        titlechoose.click();
        WebElement nameText = driver.findElement(By.xpath("//input[@id='name']"));
        Assert.assertEquals(nameText.getAttribute("value"), "yasin");
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        Assert.assertEquals(email.getAttribute("value"),"yasin@deger.com");

    }
}
