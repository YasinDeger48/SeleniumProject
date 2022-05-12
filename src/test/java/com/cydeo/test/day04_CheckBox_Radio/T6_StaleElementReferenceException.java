package com.cydeo.test.day04_CheckBox_Radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T6_StaleElementReferenceException {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/abtest");

        WebElement cydeoLink = driver.findElement(By.xpath("//a[@href='https://cydeo.com/']"));

        if(cydeoLink.isDisplayed()){
            System.out.println("showed");
        }else{
            System.out.println("fail");
        }

        driver.navigate().refresh();

        // ya tekrar yeni reference oluşturacağız ya da try catch yapacağız

        //WebElement cydeoLink2 = driver.findElement(By.xpath("//a[@href='https://cydeo.com/']"));

        /*if(cydeoLink2.isDisplayed()){
            System.out.println("showed");
        }else{
            System.out.println("fail");
        }*/

        try{
            if(cydeoLink.isDisplayed()){
                System.out.println("showed");
            }else{
                System.out.println("fail");
            }
        }catch (StaleElementReferenceException e){
            e.getMessage();
            System.out.println("Bağlantı koptu program sıçtı");
            System.out.println("Tekrar kullanmak istersen yeni find element ile bağlayacan");
        }

        driver.quit();
    }
}
