package com.cydeo.oscarReview.review06;

import com.cydeo.myExamples.automationExerciseCom.TechTask.util.ConfigFileReader;
import com.cydeo.test.base.TestBase;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import org.testng.annotations.Test;

public class TestCaseAdidas extends TestBase {

    @Test
    public void test(){

        double expectedPrice=0;
        Driver.getDriver().get(ConfigFileReader.getProperty("env"));

        expectedPrice += ReviewUtils.addProduct(Driver.getDriver(), ConfigFileReader.getProperty("category1"),"Sony vaio i5");

        expectedPrice+= ReviewUtils.addProduct(Driver.getDriver(), ConfigFileReader.getProperty("category2"),"Dell i7 8gb");

        System.out.println(expectedPrice);
        Driver.getDriver().quit();

    }

}
