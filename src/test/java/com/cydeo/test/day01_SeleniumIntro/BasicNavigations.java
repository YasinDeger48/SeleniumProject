package com.cydeo.tests.day01_Selenium_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();


        WebDriver driver = new ChromeDriver();
        //SessionID = asmda0qe  // session id oluşur.


        driver.manage().window().maximize(); //maximize eder


        driver.get("https://www.google.com");
        Thread.sleep(3000);
        driver.get("https://www.tesla.com");
        String title = driver.getTitle();//Tesla olacak
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.get("https://alcpts.com");
        String alcptsTitle = driver.getTitle();
        Thread.sleep(3000);
        driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().to("https://www.google.com");
        Thread.sleep(3000);
        System.out.println(alcptsTitle);
        if(title.equals("Google")){  //Bulunduğu yer teslayı aldığı için wrong site uyarısı verecek
            System.out.println("Correct site");
        }else {
            System.out.println("Wrong site");
        }
        String currentURL = driver.getCurrentUrl();
        Thread.sleep(2000);
        System.out.println(currentURL);
        driver.quit();

        /*
        * https://www.tesla.com/
        * title:Electric Cars, Solar & Clean Energy | Tesla
        *
        * https://www.google.com/
        * title:Google
        *
        *
        * */

    }
}
