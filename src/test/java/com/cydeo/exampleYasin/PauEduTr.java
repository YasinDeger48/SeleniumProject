package com.cydeo.exampleYasin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PauEduTr {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.pau.edu.tr/");
        WebElement fa = driver.findElement(By.className("fa"));
        fa.click();

        Thread.sleep(5000);

        WebElement academicBtn = driver.findElement(By.linkText("Akademik"));
        String academiktext = academicBtn.getText();
        System.out.println(driver.getTitle().equals("Pamukkale Üniversitesi"));
        if(academiktext.equals("Akademik")){
            System.out.println("title verification passed");
        }else{
            System.out.println("title verification failed");
        }
        academicBtn.click();

        Thread.sleep(5000);


        driver.quit();



    }
}
