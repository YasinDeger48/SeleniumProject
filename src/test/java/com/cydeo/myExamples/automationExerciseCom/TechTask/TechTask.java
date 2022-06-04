package com.cydeo.myExamples.automationExerciseCom.TechTask;

import com.cydeo.myExamples.automationExerciseCom.TechTask.testBase.Base;
import com.cydeo.myExamples.automationExerciseCom.TechTask.util.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TechTask {

    WebDriver driver;

    @Test
    public void tech_Task(){
        driver = Driver.getDriver();

        driver.get("https://qa-recruitment-task.netlify.app/");



    }
}
