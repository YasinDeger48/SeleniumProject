package com.cydeo.utilities;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {


    private static Properties prop = new Properties();

    static {

        try{
            InputStream file = new FileInputStream("configuration.properties");
            prop.load(file);
            file.close();
        }catch (IOException exp){
            System.out.println("Config Read problem!!!");
        }


    }

    public static String getProperty(String keyword){

        return prop.getProperty(keyword);
    }
}
