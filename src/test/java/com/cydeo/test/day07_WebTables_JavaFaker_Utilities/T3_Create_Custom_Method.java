package com.cydeo.test.day07_WebTables_JavaFaker_Utilities;

import com.cydeo.test.base.TestBase;
import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_Create_Custom_Method extends TestBase {



    @Test
    public void test1(){

        driver.get("https://practice.cydeo.com/tables");

        WebTableUtils.getTableGetEmail(driver,"1","Jason");
    }

}
