package com.cydeo.test.day08_WebTableContinue_Properties_ConfigurationReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

        //1. Create the object of Properties

        private static Properties properties = new Properties();

        static {

            try {
                //2. We need to open the file in java memory
                FileInputStream file = new FileInputStream("configuration.properties");

                //3. load the properties object using FileInputStream object
                properties.load(file);

                //close the file

                file.close();

            } catch (IOException e) {
                System.out.println("Something happened in ConfigurationReader Class");
            }

        }


        public static String getProperty(String keyword){

            return properties.getProperty(keyword);

        }


}
