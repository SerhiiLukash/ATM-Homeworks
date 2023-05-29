package com.epam.atm.service;

import java.util.ResourceBundle;

public class TestDataReader implements ITestDataReader{
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));

    public String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}



