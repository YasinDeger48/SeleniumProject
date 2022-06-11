package com.cydeo.oscarReview.review06.tests;

import com.cydeo.oscarReview.review06.pomForReview.CherCherHomepage;
import com.cydeo.oscarReview.review06.pomForReview.SmartBearPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SmartBearTask {

    SmartBearPage sbp;
    WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        sbp = new SmartBearPage();
        wait = new WebDriverWait(Driver.getDriver(),10);
    }


    @AfterMethod
    public void tearDown(){
        BrowserUtils.sleep(2);
        Driver.stopSession();
    }

    @Test
    public void smart_bear_test1(){
        //Task3:
        //    1. Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        //    2. Login with username: Tester, password: test
        sbp.userName.sendKeys("Tester");
        sbp.passWord.sendKeys("test");
        sbp.loginButton.click();
        //    3. Click  Order button
        sbp.orderLink.click();
        //    4. Verify under Product Information, selected option is “MyMoney”
        Select select = new Select(sbp.dropdown);
        select.selectByValue("MyMoney");
        //select.selectByIndex(0);
        //select.selectByVisibleText("MyMoney");
        //    5. Then select FamilyAlbum, make quantity 2, and click Calculate,
        select.selectByVisibleText("FamilyAlbum");
        sbp.quantity.clear();
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick().sendKeys("2").perform();
        sbp.calculateButton.click();
        //    6. Then verify Total is equal to Quantity*PricePerUnit


    }
}
