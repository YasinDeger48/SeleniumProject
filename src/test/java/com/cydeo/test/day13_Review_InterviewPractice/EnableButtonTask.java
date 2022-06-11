package com.cydeo.test.day13_Review_InterviewPractice;

import com.cydeo.pages.DynamicControls;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EnableButtonTask {

    DynamicControls dynamicControls;

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        dynamicControls = new DynamicControls();
    }

    @Test
    public void enable_button_test(){

        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        //3- Click to “Enable” button
        dynamicControls.enableButton.click();
        //4- Wait until “loading bar disappears”
        BrowserUtils.waitForInvisibilityOf(dynamicControls.loadingBar);
        //5- Verify:
        //a. Input box is enabled.
        //b. “It’s enabled!” message is displayed.
        //
        //NOTE: FOLLOW POM


    }
}
