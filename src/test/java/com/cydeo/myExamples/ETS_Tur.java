package com.cydeo.myExamples;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import jdk.jfr.Timespan;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.rmi.UnexpectedException;

public class ETS_Tur {



    @Test
    public void ets_locator_psuedo_code_java_executor(){

        Driver.getDriver().get("https://www.etstur.com/");
        BrowserUtils.sleep(2);

        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//div[@class='dropdown-menu-item']"))).build().perform();

        BrowserUtils.sleep(2);

        Driver.getDriver().findElement(By.xpath("//button[@type='button']//span[.=' Üye Ol ']")).click();

        BrowserUtils.sleep(2);

       // actions.moveToElement(Driver.getDriver().findElement(By.xpath("//input[@class='custom-control-input ets-MUST']"))).click().pause(2000).build().perform();
        //Driver.getDriver().findElement(By.xpath("//div[starts-with(@class,'form-check')]")).click();
        //Driver.getDriver().findElement(By.tagName("::before")).click();
        //((JavascriptExecutor)Driver.getDriver()).executeScript("document.getElementsById('cb-termPrivacy')._tick()");

        //WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 10);
        //wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='checkbox']")));


        //WebDriverWait wait3 = new WebDriverWait(Driver.getDriver(), 10);
        //wait3.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));

        //WebElement ele = Driver.getDriver().findElement(By.xpath("//input[@type='checkbox']"));
        //System.out.println("ele.isDisplayed() = " + ele.isDisplayed());

       /* WebElement ele = Driver.getDriver().findElement(By.xpath("//div[@class='btn btn-facebook-connect']"));

        Point point = ele.getLocation();

        int xcoordinate = point.getX();
        int ycoordinate = point.getY();

        System.out.println(xcoordinate);
        System.out.println(ycoordinate);

        actions.moveByOffset(673,485).click();
        actions.build().perform();*/

        /*JavascriptExecutor executor4= (JavascriptExecutor)Driver.getDriver();
        executor4.executeScript("document.getElementById('cb-termPrivacy').style.display='block';");
        Driver.getDriver().findElement(By.cssSelector("input#cb-termPrivacy.custom-control-input")).click();*/

        String locate = "#cb-termPrivacy";
        ((JavascriptExecutor)Driver.getDriver()).executeScript("document.querySelector(arguments[0],':before').click();",locate);

        //WebElement checkbox = Driver.getDriver().findElement(By.tagName("input"));
        //actions.moveToElement(checkbox).click().build().perform();


        BrowserUtils.sleep(5);

        Driver.stopSession();
    }
}
