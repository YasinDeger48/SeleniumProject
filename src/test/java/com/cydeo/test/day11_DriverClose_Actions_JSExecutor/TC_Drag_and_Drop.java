package com.cydeo.test.day11_DriverClose_Actions_JSExecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Drag_and_Drop {


    @Test
    public void drag_drop_test(){

        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //Locate ""AcceptCookiesButton

        WebElement acceptCookiesButton = Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));

        acceptCookiesButton.click();

        //Locate small and big circles
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        Actions actions = new Actions(Driver.getDriver());
        //actions.dragAndDrop(smallCircle,bigCircle).perform();
        BrowserUtils.sleep(2);

        //click and hold methodunu kullanarak da yapabiliriz.
        //actions.clickAndHold().dragAndDrop(smallCircle,bigCircle).perform();
        actions.clickAndHold(smallCircle)
                .pause(2000)
                .moveToElement(bigCircle)
                .pause(2000)
                .release()
                .pause(2000)
                .perform();
        BrowserUtils.sleep(2);


        String actualBigCircleText = bigCircle.getText();
        String expectedBigCircleText = "You did great!";

        Assert.assertEquals(actualBigCircleText,expectedBigCircleText);

        Driver.stopSession();

    }
}
