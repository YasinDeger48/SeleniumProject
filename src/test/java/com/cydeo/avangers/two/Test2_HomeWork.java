package com.cydeo.avangers.two;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class Test2_HomeWork {

    @Test
    public void test(){
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB,"test");

        Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button")).click();

        Driver.getDriver().findElement(By.xpath("//ul[@id='ctl00_menu']//li//a[.='Order']")).click();



        Driver.stopSession();
    }
}
