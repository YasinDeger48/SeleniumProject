package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebTableUtils {

    public static String returnOrderDate(WebDriver driver, String customerName){

        WebElement nameOfTheCustomer = driver.findElement(By.xpath("//td[.= '"+ customerName +"']//following-sibling::td[3]"));

        return nameOfTheCustomer.getText();
    }

    public static void orderVerify(WebDriver driver, String customerName, String expectedOrderDate){

        WebElement nameOfTheCustomer = driver.findElement(By.xpath("//td[.= '"+ customerName +"']//following-sibling::td[3]"));

        String actualDate = nameOfTheCustomer.getText();
        String expectedDate = expectedOrderDate;

        Assert.assertTrue(actualDate.equals(expectedDate),"Actual Date and Expected Date is not matching");


    }

    public static void getTableGetEmail(WebDriver driver, String tableNum, String firstName){

        WebElement emailElement = driver.findElement(By.xpath("//table[@id='table" + tableNum + "']//tbody//tr//td[.='" + firstName + "']//following-sibling::td[1]"));
        System.out.println(emailElement.getText());
        System.out.println("Table: "+tableNum);
    }
}
