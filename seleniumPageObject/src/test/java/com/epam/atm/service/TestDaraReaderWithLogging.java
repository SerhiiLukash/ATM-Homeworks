package com.epam.atm.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDaraReaderWithLogging implements ITestDataReader{
    private final Logger logger = LogManager.getRootLogger();
    @Override
    public String getTestData(String key) {
      String propertyValue =  decoratedTestReader.getTestData(key);
      logger.info("Key :" + key + "and value :" + propertyValue);
     return  propertyValue;
    }
    private ITestDataReader decoratedTestReader;

    public TestDaraReaderWithLogging(ITestDataReader decoratedTestReader) {
        super();
        this.decoratedTestReader= decoratedTestReader;
    }
}
