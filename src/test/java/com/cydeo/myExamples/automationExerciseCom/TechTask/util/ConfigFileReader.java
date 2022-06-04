package com.cydeo.myExamples.automationExerciseCom.TechTask.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {


    private static Properties prop = new Properties();

    static {

        FileInputStream file = null;
        try {
            file = new FileInputStream("configuration.properties");

            prop.load(file);

            file.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String getProperty(String keyword){

        return prop.getProperty(keyword);
    }


}
