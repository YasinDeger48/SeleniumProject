package com.cydeo.test.day06_alerts_IFrame_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class T5_WindowsHandlePractice {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/windows");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void multiple_window_test(){

        //String the main pages window handle as string
        String mainHandle = driver.getWindowHandle();

        //System.out.println("mainHandle = " + mainHandle);  //mainHandle = CDwindow-C901087A40A6A72077BA986F5F0B0AA7
        //it returns session number as a unique

        String expectedTitle = "Windows";
        String actualTitle = driver.getTitle();

        //Assert.assertEquals(actualTitle,expectedTitle,"these are not same (actual title = expected title)");
        Assert.assertTrue(actualTitle.equals(expectedTitle),"these are not same (actual title = expected title)");

        System.out.println("Title before click: " + actualTitle);
        //Click to : ClickHere link

        WebElement click_here_button = driver.findElement(By.linkText("Click Here"));
        click_here_button.click();

        actualTitle = driver.getTitle();
        System.out.println("Title after click: " + actualTitle);

        //Switch the new window

        Set<String> windowHandles = driver.getWindowHandles();

        for (String each : windowHandles) {
            driver.switchTo().window(each);
            System.out.println("Current title while switching the windows: " + driver.getTitle());
        }

        //Assert : title is ``New Window``
        String expectedTitleAfterClick = "New Window";
        actualTitle = driver.getTitle();
        System.out.println("Title after click: " + actualTitle);
        Assert.assertEquals(actualTitle,expectedTitleAfterClick,"After clicking title verifying");






    }
}
