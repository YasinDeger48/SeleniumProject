package com.cydeo.avangers.two;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Oscar {


    @Test
    public void test(){

        Driver.getDriver().get("https://www.automationexercise.com/products");


        Driver.getDriver().findElement(By.xpath("(//div[@class='choose'])[3]")).click();



        Driver.stopSession();
    }
}
