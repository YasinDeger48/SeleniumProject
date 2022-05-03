package com.cydeo.oscarReview.review01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateToBlazeDemo {

    static String expectedTitle = "store";
    static String link = "https://www.demoblaze.com/";

    public static void main(String[] args) {

//https://www.demoblaze.com/

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        wait(3);

       // driver.navigate().to("https://www.demoblaze.com/");

        driver.get(link);

        String actualTitle = driver.getTitle();
        System.out.println(checkTitle(actualTitle));
        wait(3);



        driver.quit();



    }
    public static boolean checkTitle(String title){
        return title.equalsIgnoreCase(expectedTitle);

    }


    public static void wait(int second){

        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
