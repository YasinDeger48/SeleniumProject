package com.cydeo.test.day12_POM_Synchronization;

import com.cydeo.pages.PracticeDynamicsPage7;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverWaitPractices {

    PracticeDynamicsPage7 practicePage;



    @Test
    public void dynamically_loaded_page_elements_7_test(){
        //1. Go to https://practice.cydeo.com/dynamic_loading/7
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");
        //2. Wait until title is “Dynamic title”
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        //Title i dynamic title yazana kadar bekliyor sonra assertin işlemine geçiyor

        //3. Assert: Message “Done” is displayed.
        practicePage = new PracticeDynamicsPage7();
        Assert.assertTrue(practicePage.doneMessage.isDisplayed());
        //4. Assert: Image is displayed.
        Assert.assertTrue(practicePage.spongeBobImage.isDisplayed());
        //Note: Follow POM
        Driver.stopSession();

    }


}
