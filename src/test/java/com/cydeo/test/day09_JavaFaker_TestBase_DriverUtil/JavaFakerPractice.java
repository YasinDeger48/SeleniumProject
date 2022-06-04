package com.cydeo.test.day09_JavaFaker_TestBase_DriverUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Locale;

public class JavaFakerPractice {

    @Test
    public void test1(){
        Faker faker = new Faker(new Locale("tr"));
        String firstName = faker.name().firstName();

        String name = faker.address().fullAddress();

        String animalName = faker.animal().name();

        String fullName = faker.name().fullName();

        String fact = faker.chuckNorris().fact();

        String colorName = faker.color().name();
        String colorHex = faker.color().hex();

        System.out.println(colorName);
        System.out.println(colorHex);

        System.out.println(fact);
        System.out.println(firstName);
        System.out.println(name);
        System.out.println(fullName);
        System.out.println(animalName);

        System.out.println("-----------------FAKER NUMERIFY PATTERN GIREBILIRIZ-----------------------");

        String phoneNumber1 = faker.numerify("###-###-##-##");

        String phoneNumber2 = faker.numerify("530-###-##-##");

        System.out.println(phoneNumber1);

        System.out.println(phoneNumber2);

        System.out.println("-----------------FAKER NUMERIFY TELEFON-----------------------");

        String phone = faker.phoneNumber().phoneNumber();
        System.out.println(phone);

        String id = faker.idNumber().validSvSeSsn();

        System.out.println(id);

        System.out.println("-----------------FAKER GENERATE LETTER- BOTH (NUMBER AND LETTER)-----------------------");

        String letter = faker.letterify("????");

        String letterify2 = faker.letterify("??-????");


        System.out.println(letter);

        System.out.println(letterify2);


        String bothify = faker.bothify("##??#?##???");
        System.out.println(bothify);

        String creditCard = faker.finance().creditCard();

        System.out.println(creditCard);

        String creditCart2 = faker.finance().creditCard().replaceAll("-", " ");

        System.out.println(creditCart2);
    }
}
