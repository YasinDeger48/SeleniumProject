package com.cydeo.test.day04_CheckBox_Radio.task;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class T1 {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/forgot_password");

        // Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)

        //a. “Home” link

        //WebElement homeLink = driver.findElement(By.cssSelector("a[class='nav-link']"));
        WebElement homeLink2 = driver.findElement(By.xpath("//a[@href='/']"));
        homeLink2.click();
        driver.navigate().back();
        BrowserUtils.sleep(2);
        //b. “Forgot password” header

        //WebElement forgotPasswordHeader = driver.findElement(By.cssSelector("div.example h2"));
        WebElement forgotPasswordHeader2 = driver.findElement(By.xpath("//*[@id='content']/div/h2"));
        System.out.println("forgotPasswordHeader.getText() = " + forgotPasswordHeader2.getText());
        BrowserUtils.sleep(2);


        // c. “E-mail” text

        //WebElement emailText = driver.findElement(By.xpath("//label[@for='email']"));
        WebElement emailText2 = driver.findElement(By.cssSelector("#content label"));
        System.out.println("emailText.getText() = " + emailText2.getText());
        BrowserUtils.sleep(2);

        //d. E-mail input box

        //WebElement emailInputBox = driver.findElement(By.xpath("//input[@name='email']"));
        //WebElement emailInputBox2 = driver.findElement(By.xpath("//input[contains(@pattern, 'a-z')]"));
        WebElement emailInputBox3 = driver.findElement(By.cssSelector("input[name='email']"));
        emailInputBox3.sendKeys("abcd@abcd.com" + Keys.ENTER);
        BrowserUtils.sleep(2);
        driver.navigate().back();


        //e. “Retrieve password” button

        //WebElement retrievePassButton = driver.findElement(By.cssSelector("button[id='form_submit']"));
        WebElement retrievePassButton2 = driver.findElement(By.xpath("//button[@type='submit']"));
        retrievePassButton2.click();
        BrowserUtils.sleep(2);

        driver.navigate().back();
        // f. “Powered by Cydeo text

        //WebElement cydeoText = driver.findElement(By.cssSelector("div[style='text-align: center;']"));
        WebElement cydeoText2 = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        System.out.println("cydeoText.getText() = " + cydeoText2.getText());
        BrowserUtils.sleep(2);


        System.out.println("homeLink2.isDisplayed() = " + homeLink2.isDisplayed());
        System.out.println("forgotPasswordHeader2.isDisplayed() = " + forgotPasswordHeader2.isDisplayed());
        System.out.println("emailText2.isDisplayed() = " + emailText2.isDisplayed());
        System.out.println("emailInputBox3.isDisplayed() = " + emailInputBox3.isDisplayed());
        System.out.println("retrievePassButton2.isDisplayed() = " + retrievePassButton2.isDisplayed());
        System.out.println("cydeoText2.isDisplayed() = " + cydeoText2.isDisplayed());


        driver.quit();

    }
}
