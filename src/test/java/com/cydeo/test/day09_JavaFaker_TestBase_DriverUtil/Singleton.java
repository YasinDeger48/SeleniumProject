package com.cydeo.test.day09_JavaFaker_TestBase_DriverUtil;

public class Singleton {


    //1. create private constructor
    private Singleton(){
    }

    //2. private static String
    //prevent access and provide a getter method
    private static String word;

    //this utility method will return the   "word"   in the way we want to return
    public static String getWord(){

        if(word == null){
            System.out.println("First time call. Word object is null, Assignin value to it now!");
            word = "something";
        }else{
            System.out.println("Word already has value");
        }

        return word;
    }







}
