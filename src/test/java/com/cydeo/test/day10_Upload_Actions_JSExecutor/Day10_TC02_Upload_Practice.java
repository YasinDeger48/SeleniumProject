package com.cydeo.test.day10_Upload_Actions_JSExecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day10_TC02_Upload_Practice {

    //1. Go to https://practice.cydeo.com/upload
    //        2. Find some small file from your computer, and get the path of it.
    //        3. Upload the file.
    //    4. Assert:-File uploaded text is displayed on the page

    @Test
    public void upload_test(){

        Driver.getDriver().get("https://practice.cydeo.com/upload");

        WebElement chooseButton = Driver.getDriver().findElement(By.id("file-upload"));
        BrowserUtils.sleep(2);

        String path = "/Users/values/Desktop/Screen Shot 2022-05-26 at 19.18.28.png";
        chooseButton.sendKeys(path);
        BrowserUtils.sleep(2);

        Driver.getDriver().findElement(By.id("file-submit")).click();
        BrowserUtils.sleep(2);

        String uploadedFileCaption = Driver.getDriver().findElement(By.id("uploaded-files")).getText();
        String expectedFile = "Screen Shot 2022-05-26 at 19.18.28.png";

        String actualConfirmUpload = Driver.getDriver().findElement(By.tagName("h3")).getText();
        String expectedConfirmUpload = "File Uploaded!";

        Assert.assertTrue(actualConfirmUpload.equals(expectedConfirmUpload),"tagName verifications");

        Assert.assertTrue(uploadedFileCaption.equals(expectedFile),"Correct file does not uploaded");


        Driver.stopSession();

    }

}
