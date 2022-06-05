package com.cydeo.test.day10_Upload_Actions_JSExecutor;

import com.cydeo.myExamples.automationExerciseCom.TechTask.util.ConfigFileReader;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.Wait;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class TC01 {
    Faker faker = new Faker(new Locale("en"));
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    @Test
    public void test1(){

        Driver.getDriver().get(ConfigFileReader.getProperty("registration.from.url"));
        WebElement firstName = Driver.getDriver().findElement(By.cssSelector("input[name='firstname']"));
        firstName.sendKeys(faker.name().firstName(), Keys.TAB, faker.name().lastName(),Keys.TAB,faker.bothify("????????##"),Keys.TAB,
                faker.internet().emailAddress(),Keys.TAB,faker.internet().password(),Keys.TAB,faker.numerify("571-###-####"),Keys.TAB);

        WebElement genderSelect = Driver.getDriver().findElement(By.xpath("(//div[@class='radio']//input)[1]"));
        genderSelect.click();

        WebElement dateOfBirth = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        dateOfBirth.sendKeys(sdf.format(faker.date().birthday()));

        Select select = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        select.selectByValue("AO");
        select = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        select.selectByVisibleText("SDET");

        Driver.getDriver().findElement(By.xpath("//input[@value='java']")).click();

        Driver.getDriver().findElement(By.id("wooden_spoon")).click();


        Wait.wait(2);

        WebElement wellDoneElement = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-success']//p"));
        String actualText = wellDoneElement.getText();
        String expectedText = "You've successfully completed registration!";

        Assert.assertTrue(actualText.equals(expectedText),"Actual test is not matching with the expected text");
        System.out.println("Test completed...");
        Driver.stopSession();
    }

}
