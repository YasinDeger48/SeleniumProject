package com.cydeo.test.day05_Intro_Dropdowns;

import com.cydeo.utilities.Wait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T5_Dropdown {
    WebDriver driver;
    Select dropDown;
    int testCounter=0;
    @BeforeMethod
    public void setUp(){
        System.out.println(testCounter+1 + ". test started");
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
        dropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

    }
    @AfterMethod
    public void finish(){
        System.out.println(testCounter+ ". test finished");
        driver.quit();
    }

    @Test(priority = 1)
    public void SelectIllinois(){

        String ill = "Illinois";

        dropDown.selectByVisibleText(ill);
        testCounter++;


    }

    @Test(priority = 2)
    public void SelectVirginia(){


        List<WebElement> allOptions = dropDown.getOptions();

        String vir = "Virginia";


        for (int i = 0; i < allOptions.size(); i++) {
            if(allOptions.get(i).getText().equals(vir)){
                dropDown.selectByIndex(i);
            }
        }
        testCounter++;



    }

    @Test(priority = 3)
    public void SelectCalifornia(){

        String caliValue = "CA";

        dropDown.selectByValue(caliValue);
        testCounter++;

        Wait.wait(5);


        WebElement verify = dropDown.getFirstSelectedOption();

        if(verify.getText().equals("California")){
            System.out.println("Final value passed!");
        }else{
            System.out.println("Final value failed!");
        }

    }

}
