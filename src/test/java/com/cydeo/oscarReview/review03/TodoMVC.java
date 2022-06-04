package com.cydeo.oscarReview.review03;

import com.cydeo.utilities.Wait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TodoMVC {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://todomvc.com");
        Wait.wait(1);

        driver.navigate().to("https://todomvc.com/examples/react/#/");
        Wait.wait(1);

        WebElement element = driver.findElement(By.className("new-todo"));
        Wait.wait(1);

        element.sendKeys("Keys"+ Keys.ENTER);
        Wait.wait(1);




        driver.quit();
    }
}
