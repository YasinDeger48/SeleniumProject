package com.cydeo.oscarReview.review05.WindowHandleTask;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Window_Handle_Task {
    WebDriver driver;
    /*
    automate the following scenarios for this website https://shino.de/parkcalc/
Scenario 1)
-  Using the Valet parking lot, set today as the entry date & time and tomorrow as the exit giving a full 24 hour window (you can attempt to use the DatePicker).
     */


    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://shino.de/parkcalc/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test3() {


        Date today = new Date();
        int todayDay = 31;//today.getDay();
        int todayYear = today.getYear();
        int todayMonth = today.getMonth();
        int todayHours = today.getHours();
        int todayMinutes = today.getMinutes();



        int dayNumber = 1;
        String AMPM = "AM";
        String expectedMonth="May";
        int expectedYear = todayYear;

        String expectedEntryTime = ""+todayHours+":"+todayMinutes+"";



        String expectedDay = String.valueOf(todayDay);


        if(todayHours<24 && todayHours>12){
            AMPM = "PM";
        }

        switch (todayMonth){
            case 0:
                expectedMonth =  "January";
                break;
            case 1:
                expectedMonth = "February";
                break;
            case 2:
                expectedMonth = "March";
                break;
            case 3:
                expectedMonth = "April";
                break;
            case 4:
                expectedMonth = "May";
                break;
            case 5:
                expectedMonth = "June";
                break;
            case 6:
                expectedMonth = "July";
                break;
            case 7:
                expectedMonth = "August";
                break;
            case 8:
                expectedMonth = "September";
                break;
            case 9:
                expectedMonth = "October";
                break;
            case 10:
                expectedMonth = "November";
                break;
            case 11:
                expectedMonth = "December";
                break;
        }

        /* Using the Valet parking lot,
        set today as the entry date & time and tomorrow as the exit giving a full 24 hour window
        (you can attempt to use the DatePicker */




        Select select = new Select(driver.findElement(By.cssSelector("select[id='ParkingLot']")));
        //select.selectByVisibleText("Valet Parking");
        //select.selectByIndex(0);
        select.selectByValue("Valet");
        WebElement selectedOption = select.getFirstSelectedOption();



        //SET ENTRY DATE
        WebElement findDatePickScreen = driver.findElement(By.xpath("(//img[@src='cal.gif'])[1]"));
        findDatePickScreen.click();

        windowHandle(driver, "Pick a Date");

        BrowserUtils.sleep(2);




        Select select1 = new Select(driver.findElement(By.xpath("//select[@name='MonthSelector']")));
        select1.selectByVisibleText(expectedMonth);
        BrowserUtils.sleep(1);

        WebElement yearOfDate = driver.findElement(By.xpath("//table[tbody]//tr[1]//td[2]/font"));
        int actualYear = Integer.parseInt(yearOfDate.getText());
        int clickTime;
        if (expectedYear != actualYear) {
            if (expectedYear > actualYear) {
                clickTime = expectedYear - actualYear;
            } else {
                clickTime = actualYear - expectedYear;
            }
        }
        BrowserUtils.sleep(1);

        WebElement dayOfDate = driver.findElement(By.xpath("(//table[tbody]//td/font//a)[" + expectedDay + "]"));
        dayOfDate.click();
        BrowserUtils.sleep(3);


        windowHandle(driver, "Pick a Date");


        WebElement entryTime = driver.findElement(By.xpath("//input[@name='StartingTime']"));
        String actualTime = entryTime.getAttribute("value");
        entryTime.clear();
        entryTime.sendKeys(expectedEntryTime);
        BrowserUtils.sleep(2);

        WebElement ampmRadio = driver.findElement(By.xpath("(//input[@value='" + AMPM + "'])[1]"));
        ampmRadio.click();
        driver.switchTo().defaultContent();



        //SET LEAVING DATE

        switch (todayDay){
            case 31:
                switch (todayMonth){
                    case 0: case 2: case 4: case 6:case 7:case 9:case 11:
                        if(todayDay == 31){
                            todayDay = 1;
                        }
                        todayMonth++;
                        expectedDay = String.valueOf(todayDay);

                        break;
                    case 3: case 5: case 8: case 10:
                        if(todayDay == 30){
                            todayDay = 1;

                        }
                        todayMonth++;
                        expectedDay = String.valueOf(todayDay);
                        break;

                    case 1:
                        if(todayDay == 28){
                            todayDay = 1;

                        }
                        todayMonth++;
                        expectedDay = String.valueOf(todayDay);

                }
                break;
            case 30:
                switch (todayMonth){
                    case 0: case 2: case 4: case 6:case 7:case 9:case 11:
                        if(todayDay == 31){
                            todayDay = 1;
                        }
                        todayMonth++;

                        break;
                    case 3: case 5: case 8: case 10:
                        if(todayDay == 30){
                            todayDay = 1;

                        }
                        todayMonth++;

                    case 1:
                        if(todayDay == 28){
                            todayDay = 1;

                        }
                        todayMonth++;

                }
                break;
            case 28:
                switch (todayMonth){
                    case 0: case 2: case 4: case 6:case 7:case 9:case 11:
                        if(todayDay == 31){
                            todayDay = 1;
                        }
                        todayMonth++;

                        break;
                    case 3: case 5: case 8: case 10:
                        if(todayDay == 30){
                            todayDay = 1;

                        }
                        todayMonth++;

                    case 1:
                        if(todayDay == 28){
                            todayDay = 1;

                        }
                        todayMonth++;

                }
                break;

        }


        switch (todayMonth){
            case 0:
                expectedMonth =  "January";
                break;
            case 1:
                expectedMonth = "February";
                break;
            case 2:
                expectedMonth = "March";
                break;
            case 3:
                expectedMonth = "April";
                break;
            case 4:
                expectedMonth = "May";
                break;
            case 5:
                expectedMonth = "June";
                break;
            case 6:
                expectedMonth = "July";
                break;
            case 7:
                expectedMonth = "August";
                break;
            case 8:
                expectedMonth = "September";
                break;
            case 9:
                expectedMonth = "October";
                break;
            case 10:
                expectedMonth = "November";
                break;
            case 11:
                expectedMonth = "December";
                break;
        }


        findDatePickScreen = driver.findElement(By.xpath("(//img[@src='cal.gif'])[2]"));
        findDatePickScreen.click();

        windowHandle(driver, "Pick a Date");

        BrowserUtils.sleep(2);

        //expectedDay = String.valueOf(todayDay);
        int leaveDay = Integer.parseInt(expectedDay);


        select1 = new Select(driver.findElement(By.xpath("//select[@name='MonthSelector']")));
        select1.selectByVisibleText(expectedMonth);
        BrowserUtils.sleep(1);

        yearOfDate = driver.findElement(By.xpath("//table[tbody]//tr[1]//td[2]/font"));
        actualYear = Integer.parseInt(yearOfDate.getText());


        BrowserUtils.sleep(1);

        dayOfDate = driver.findElement(By.xpath("(//table[tbody]//td/font//a)/..//a[.='"+leaveDay+"']"));
        dayOfDate.click();
        BrowserUtils.sleep(3);


        windowHandle(driver, "Pick a Date");


        entryTime = driver.findElement(By.xpath("//input[@name='LeavingTime']"));
        //actualTime = entryTime.getAttribute("value");
        entryTime.clear();
        entryTime.sendKeys(expectedEntryTime);
        BrowserUtils.sleep(2);

        ampmRadio = driver.findElement(By.xpath("(//input[@value='" + AMPM + "'])[2]"));
        ampmRadio.click();
        BrowserUtils.sleep(2);

        WebElement calculateButton = driver.findElement(By.xpath("//input[@name='Submit']"));
        calculateButton.click();
        WebElement actualCost = driver.findElement(By.xpath("//tbody/tr[4]//td[2]//span[1]"));
        String actualPrice = actualCost.getText();
        String expectedPrice = "$ " +parkingCalculation(driver,selectedOption, dayNumber);
        BrowserUtils.sleep(2);


        Assert.assertTrue(actualPrice.equals(expectedPrice),"Actual and Expected price is not matching");


    }

    public static void windowHandle(WebDriver driver, String pickDateWindowTitle) {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            driver.switchTo().window(each);

            if (driver.getTitle().equals(pickDateWindowTitle)) {
                break;
            }
        }
    }

    public static String parkingCalculation(WebDriver driver, WebElement element, int day){

        double result =0;
        Select select = new Select(driver.findElement(By.cssSelector("select[id='ParkingLot']")));

        WebElement choosenOne = select.getFirstSelectedOption();


        if(choosenOne.getAttribute("value").equals("Valet")){

             result = day *18;

        }else if(choosenOne.getAttribute("value").equals("Short")){


        }else if(choosenOne.getAttribute("value").equals("Economy")){


        }else if(choosenOne.getAttribute("value").equals("Long-Garage")){


        }else if(choosenOne.getAttribute("value").equals("Long-Surface")){


        }

        return String.valueOf(result)+"0";
    }


}
