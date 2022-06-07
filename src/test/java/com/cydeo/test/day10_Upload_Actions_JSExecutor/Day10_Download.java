package com.cydeo.test.day10_Upload_Actions_JSExecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Day10_Download {

    private RemoteWebDriver driver;
    @BeforeClass
    public void setup(){



        ChromeOptions options = new ChromeOptions();

        Map<String,Object> prefs = new HashMap<>();
        prefs.put("download.prompt_for_download",false);
        options.setExperimentalOption("prefs",prefs);

        driver = new ChromeDriver(options);




    }

    @Test
    public void test(){

        driver.get("https://www.oracle.com/java/technologies/javase-jdk8-doc-downloads.html");

        WebElement document = driver.findElement(By.xpath("(//div[@class='cb133-download'])[2]"));


        document.click();

        driver.close();
    }
}
