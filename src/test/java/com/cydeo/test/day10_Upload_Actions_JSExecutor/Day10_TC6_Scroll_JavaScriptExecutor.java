package com.cydeo.test.day10_Upload_Actions_JSExecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import javax.swing.*;

public class Day10_TC6_Scroll_JavaScriptExecutor {

    @Test
    public void scroll_test(){

        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,750)"); //bu şekilde de  yazılabilir.


        //a.  750 pixels down 10 times.
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,750)");

        }

        //b.  750 pixels up 10 times
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,-750)");

        }

        Driver.stopSession();


        
    }
}
