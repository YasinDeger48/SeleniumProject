package com.cydeo.oscarReview.review02;

import com.cydeo.utilities.Wait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task02 {
    public static void main(String[] args) throws InterruptedException {


        //Which exception you get the most?

           // - No such element exception:
            // * your locator is wrong
             // * web page loading time is slower than your selenium /java code.



        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/");
        WebElement forgot_password = driver.findElement(By.linkText("Forgot Password"));
        Wait.wait(2);
        forgot_password.click();

        String mail = "yasin@deger.com";
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(mail);
        Wait.wait(2);


        WebElement email2 = driver.findElement(By.name("email"));
        String actualEmail = email2.getAttribute("value");
        if(actualEmail.equals(mail)){
            System.out.println("good e-mail");
        }else{
            System.out.println("bad e-mail");
        }

        WebElement form_submit = driver.findElement(By.id("form_submit"));
        form_submit.click();
        Wait.wait(2);

       // XPATH:

      //  absolute: full xpath link  -- /html/body/div/div[2]/div/div/form/button/i  önerilmez

       // relative:  //*[@id="form_submit"]/i  ilgili elemente git sağ tıkla copy xpath full or xpath




        WebElement confirmation_message = driver.findElement(By.name("confirmation_message"));
        if(confirmation_message.isDisplayed() && confirmation_message.getText().equals("Your e-mail's been sent!")){
            System.out.println("true");
        }else{
            System.out.println("false");
        }


        driver.quit();

    }
}
