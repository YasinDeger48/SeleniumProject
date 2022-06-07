package com.cydeo.test.day04_CheckBox_Radio;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

public class Task1_2 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/forgot_password");
        BrowserUtils.sleep(2);


        // a.home link
        WebElement homeLink = driver.findElement(By.cssSelector("a[class='nav-link']"));
        //WebElement homeLink2 = driver.findElement(By.cssSelector("a.nav-link"));
        //WebElement homeLink3 = driver.findElement(By.cssSelector("a[href='/']"));
        //WebElement homeLink4 = driver.findElement(By.linkText("Home"));

        //forgot password header
        WebElement forgotPassword = driver.findElement(By.cssSelector("div.example > h2"));
        //WebElement forgotPassword2 = driver.findElement(By.cssSelector("#content div.example > h2"));
        //WebElement forgotElement3 = driver.findElement(By.xpath("//h2[text() = 'Forgot Password']"));


        //E-mail text

        WebElement emailText = driver.findElement(By.cssSelector("label[for='email']"));
        //WebElement emailText2 = driver.findElement(By.cssSelector("#content div > label"));
        //WebElement emailText3 = driver.findElement(By.xpath("//label[@for='email']"));
        //WebElement emailText4 = driver.findElement(By.cssSelector("#forgot_password div > label"));


        //E-mail input box
        WebElement emailInputBox = driver.findElement(By.cssSelector("input[name='email']"));
        //WebElement emailInputBox2 = driver.findElement(By.cssSelector("#content input"));
        //WebElement emailInputBox3 = driver.findElement(By.xpath("//input[contains(@pattern, 'a-z')]"));  //contains


        //Retrieve Password Button

        WebElement retrieveButton = driver.findElement(By.cssSelector("button#form_submit"));
        //WebElement retrieveButton2 = driver.findElement(By.xpath("//button[@type='submit']"));

        //Powered By CYDEO text

        WebElement cydeoText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));


        //Verify all web elements

        System.out.println("homeLink = " + homeLink.isDisplayed());
        System.out.println("forgotPassword = " + forgotPassword.isDisplayed());
        System.out.println("emailText.isDisplayed() = " + emailText.isDisplayed());
        System.out.println("emailInputBox = " + emailInputBox.isDisplayed());
        System.out.println("retrieveButton = " + retrieveButton.isDisplayed());
        System.out.println("cydeoText = " + cydeoText.isDisplayed());

        driver.quit();


    }
}
