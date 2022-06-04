package com.cydeo.test.day08_WebTableContinue_Properties_ConfigurationReader;

import org.testng.annotations.Test;

public class PropertiesLearning {

    @Test
    public void java_properties_reading_test(){
        System.out.println("System.getProperties(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));

    }
}
