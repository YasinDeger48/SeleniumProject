package com.cydeo.test.day13_Review_InterviewPractice;

import com.cydeo.pages.DoubleClickPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01_Double_Click {


    @Test
    public void double_click(){
        //1. Go to
        //https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2

        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        //2. Switch to iframe.

        WebElement iframe = Driver.getDriver().findElement(By.id("iframeResult"));
        Driver.getDriver().switchTo().frame(iframe);

        //Driver.getDriver().switchTo().frame("iframeResult"); //name -id yazabiliriz direk

        //3. Double click on the text “Double-click me to change my text color.”

        DoubleClickPage doubleClickPage = new DoubleClickPage();

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(doubleClickPage.textToDoubleClick).doubleClick().perform();

        //4. Assert: Text’s “style” attribute value contains “red”.

        String styleOfElement = doubleClickPage.textToDoubleClick.getAttribute("style");
        String expectedResultOfElement = "color: red";
        Assert.assertTrue(styleOfElement.contains(expectedResultOfElement),"doesnt include red word in style attribute");

        //NOTE: FOLLOW POM

        Driver.stopSession();
    }
}
