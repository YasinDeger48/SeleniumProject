package com.cydeo.utilities;

import com.cydeo.test.day08_WebTableContinue_Properties_ConfigurationReader.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Driver {

    /*
    Creating a private constructor so we are closing access
    to the object of this class from outside the class*/
    //no other purpose

    private Driver(){

    }

    //we make WebDriver private, because we want to close access from out of the class
    //we make it static because we will use it in a static method

    private static WebDriver driver;

    //Create a reusable utility method

    public static WebDriver getDriver(){

        if(driver == null){

            //we read browserType from configuration.properties
            String browserType = ConfigurationReader.getProperty("browser");

            //browser type and create driver object
            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

            }




        }

        return driver;

    }
    //This method will make sure our driver value is always null after using quit() method
    public static void closeDriver(){
        if(driver != null){
            driver.quit(); // this line will terminate the existing session value will not even ben null
            //driver quit diyince session kill yap??l??yor. yeni driver ?? tan??mlamak laz??m. onu null olarak tan??ml??yoruz.
            driver = null; //bunu koymazsak sonras??ndaki testleri g??rmez null hatas?? verir. null verip driver i s??f??rlamak zorunday??z.
        }
    }


    public static void stopSession(){
        if(driver!=null){
            getDriver().quit();
            driver=null;
        }
    }

    public static void wait(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {

        }
    }




}
