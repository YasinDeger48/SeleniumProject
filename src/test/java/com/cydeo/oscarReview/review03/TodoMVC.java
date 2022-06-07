package com.cydeo.oscarReview.review03;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

public class TodoMVC {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://todomvc.com");
        BrowserUtils.sleep(1);

        driver.navigate().to("https://todomvc.com/examples/react/#/");
        BrowserUtils.sleep(1);

        WebElement element = driver.findElement(By.className("new-todo"));
        BrowserUtils.sleep(1);

        element.sendKeys("Keys"+ Keys.ENTER);
        BrowserUtils.sleep(1);




        driver.quit();
    }
}
