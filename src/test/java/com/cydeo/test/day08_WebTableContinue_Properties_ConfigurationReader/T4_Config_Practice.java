package com.cydeo.test.day08_WebTableContinue_Properties_ConfigurationReader;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class T4_Config_Practice {

/*    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        String browserType = ConfigurationReader.getProperty("browser");

        driver = WebDriverFactory.getDriver(browserType);

       // driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }*/

    //Bu yukardakiler yerine Driver.getDriver() koyuyoruz

    @AfterMethod
    public void tearDown(){
        Driver.getDriver().quit();
    }

    @Test
    public void google_search_test(){
        Driver.getDriver().get("https://www.google.com");


        WebElement googleInput = Driver.getDriver().findElement(By.xpath("//input[@name='q']"));

        googleInput.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = ConfigurationReader.getProperty("searchValue")+" - Google'da Ara";

        Assert.assertEquals(actualTitle, expectedTitle,"not matching");

        BrowserUtils.sleep(2);

    }
}
