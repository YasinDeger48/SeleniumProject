package com.cydeo.test.day07_WebTables_JavaFaker_Utilities;

import com.cydeo.test.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_CRM_Login extends TestBase {
/*    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }*/

    //Tüm metodlar aynı bazıları utilitiesden method kullanıyor ondan kısa
    //Overload methodlarla aynı isimde farklı methodlar kullandık.


    @Test
    public void crm_login_test(){
        driver.get("https://login1.nextbasecrm.com/");

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


        String expectedTitle = "Portal";
        BrowserUtils.verifyTitle(driver, expectedTitle);



    }

    @Test
    public void crm_login_test_2(){
        driver.get("https://login1.nextbasecrm.com/");

        CRM_Utilities.crm_login(driver);

        String expectedTitle = "Portal";
        BrowserUtils.verifyTitle(driver, expectedTitle);

    }

    @Test
    public void crm_login_test_3(){
        driver.get("https://login1.nextbasecrm.com/");

        String username = "helpdesk1@cybertekschool.com";
        String password = "UserUser";

        CRM_Utilities.crm_login(driver,username,password);

        String expectedTitle = "Portal";
        BrowserUtils.verifyTitle(driver, expectedTitle);

    }
}
