package com.cydeo.test.day08_WebTableContinue_Properties_ConfigurationReader;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {

    @Test
    public void reading_from_properties() throws IOException {
        //1. Create the object of Properties

        Properties properties = new Properties();

        //2. We need to open the file in java memory

        FileInputStream file = new FileInputStream("configuration.properties");

        //3. load the properties object using FileInputStream object

        properties.load(file);

        System.out.println("properties.getProperty(\"Browser\") = " + properties.getProperty("browser"));
        System.out.println(properties.getProperty("env"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));


    }
}
