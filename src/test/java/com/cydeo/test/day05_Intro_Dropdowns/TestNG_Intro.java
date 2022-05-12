package com.cydeo.test.day05_Intro_Dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {



    @Test(priority = 1)
    public void test1() {
        System.out.println("test1 is running...");
        //ASSERT EQUALS : compare 2 of the same things
        String actual = "apple";
        String expected = "apple";

        Assert.assertEquals(actual,expected);

    }

    @Test(priority = 2)
    public void test2() {
        System.out.println("test2 is running...");
//ASSERT TRUE
        String actual = "apple";
        String expected = "apple";

        Assert.assertTrue(actual.equals(expected),"your message will here");
    }



    @BeforeClass
    public void setUp(){
        System.out.println("---> BeforeClass is running");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("----> AfterClass is running");
    }

    @BeforeMethod
    public void setUpMethod() {
        System.out.println("----> BeforeMethod is running!");
    }

    @AfterMethod
    public void tearDownMethod() {
        System.out.println("---> AfterMethod is running!");
    }
}
