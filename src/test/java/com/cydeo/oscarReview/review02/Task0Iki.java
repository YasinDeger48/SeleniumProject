package com.cydeo.oscarReview.review02;

import com.cydeo.utilities.Wait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task0Iki {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        Wait.wait(2);

        String expectedTitle = "Web Orders Login";
        if(expectedTitle.equals(driver.getTitle())){
            System.out.println("success");
        }else{
            System.exit(-1);
        }
        Wait.wait(2);

        WebElement username = driver.findElement(By.name("ctl00$MainContent$username"));
        username.sendKeys("Tester");
        Wait.wait(2);
        WebElement password = driver.findElement(By.name("ctl00$MainContent$password"));
        password.sendKeys("test");
        Wait.wait(2);

        WebElement login_button = driver.findElement(By.id("ctl00_MainContent_login_button"));
        login_button.click();
        Wait.wait(2);

        String expectedHomePageTitle = "Web Orders";
        if(expectedHomePageTitle.equals(driver.getTitle())){
            System.out.println("true page");
        }else{
            System.out.println("fail page");
        }

        driver.quit();


    }
}
