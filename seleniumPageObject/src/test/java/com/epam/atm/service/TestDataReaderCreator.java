package com.epam.atm.service;

public class TestDataReaderCreator {
    public static ITestDataReader getITestDataReader() {
        return new TestDaraReaderWithLogging( new TestDataReader());
    }

}
