package com.cydeo.oscarReview.review04;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class Dropbox {

/*    Hello Future SDETs, today after session with Kuzzat, I will review first JAVA topics (Polymorphism and Intro to Collections), then I will review UI Test Automation part with you. We will do following tasks together. Before the class I want you to try it out without using any advanced knowledge. Just with the methods and knowledge that you have learned so far. There is easier ways with some advanced topics, but I want you to force yourself to solve with knowledge that you have so far related to Selenium. Test Case 1 :  Verify CheckBox, CheckAll and UncheckAll Buttons
1.    Go to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx


            2.    Login with-----Username: Tester, password: test

3.    Click on check all button verify all the checkboxes are checked
4.    Click on uncheck all button verify that all the checkboxes are unchecked
    Test Case 2
            1.    Go to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
            2.    Login with-----Username: Tester, password: test
3.    Select one of the checkbox and delete one person
4.    Then verify that deleted item is no longer exists*/

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        WebElement userName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        WebElement passWord = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));

        userName.sendKeys("Tester");
        BrowserUtils.sleep(2);
        passWord.sendKeys("test" + Keys.ENTER);
        BrowserUtils.sleep(2);

        WebElement checkAll = driver.findElement(By.id("ctl00_MainContent_btnCheckAll"));
        checkAll.click();
        BrowserUtils.sleep(2);

        WebElement ch1 = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$orderGrid$ctl02$OrderSelector']"));
        WebElement ch2 = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl03_OrderSelector']"));
        WebElement ch3 = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl04_OrderSelector']"));
        WebElement ch4 = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl05_OrderSelector']"));
        WebElement ch5 = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl06_OrderSelector']"));
        WebElement ch6 = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl07_OrderSelector']"));
        WebElement ch7 = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl08_OrderSelector']"));
        WebElement ch8 = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl09_OrderSelector']"));

        if(ch1.isSelected() && ch2.isSelected() && ch3.isSelected() && ch4.isSelected() && ch5.isSelected() &&
                ch6.isSelected() && ch7.isSelected() && ch8.isSelected() ){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

        driver.findElement(By.id("ctl00_MainContent_btnUncheckAll")).click();
        BrowserUtils.sleep(2);

        WebElement ch11 = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl02_OrderSelector']"));
        WebElement ch12 = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl03_OrderSelector']"));
        WebElement ch13 = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl04_OrderSelector']"));
        WebElement ch14 = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl05_OrderSelector']"));
        WebElement ch15 = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl06_OrderSelector']"));
        WebElement ch16 = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl07_OrderSelector']"));
        WebElement ch17 = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl08_OrderSelector']"));
        WebElement ch18 = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl09_OrderSelector']"));

        if(!(ch11.isSelected() && ch12.isSelected() && ch13.isSelected() && ch14.isSelected() && ch15.isSelected() &&
                ch16.isSelected() && ch17.isSelected() && ch18.isSelected() )){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");


        WebElement userName1 = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        WebElement passWord1 = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));

        userName1.sendKeys("Tester");
        BrowserUtils.sleep(2);
        passWord1.sendKeys("test" + Keys.ENTER);
        BrowserUtils.sleep(2);

        WebElement deletePerson = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl03_OrderSelector']"));

        deletePerson.click();

        WebElement deleteButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_btnDelete']"));
        deleteButton.click();
        BrowserUtils.sleep(1);


        if(!(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[3]/td[2]")).isDisplayed())){
            System.out.println("Person deleted");
        }else{
            System.out.println("Person can not deleted");
        }


        driver.quit();
    }
}
