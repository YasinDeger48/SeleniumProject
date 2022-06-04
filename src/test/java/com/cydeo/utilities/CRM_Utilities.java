package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {

    /*
    * This method will login with ``helpdesk1@cybertekschool.com``
    * user when it is called*/

    public static void crm_login(WebDriver driver){

        WebElement loginInput = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        WebElement passInput = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));

        //helpdesk1@cybertekschool.com
        //helpdesk2@cybertekschool.com

        loginInput.sendKeys("helpdesk1@cybertekschool.com");
        BrowserUtils.sleep(1);

        //pass : UserUser

        passInput.sendKeys("UserUser");
        BrowserUtils.sleep(1);
        loginButton.click();
    }

    //Overloaded version

    public static void crm_login(WebDriver driver,String username, String password){

        WebElement loginInput = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        WebElement passInput = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));

        //helpdesk1@cybertekschool.com
        //helpdesk2@cybertekschool.com

        loginInput.sendKeys(username);
        BrowserUtils.sleep(1);

        //pass : UserUser

        passInput.sendKeys(password);
        BrowserUtils.sleep(1);
        loginButton.click();
    }
}
