package com.epam.atm.model.user;

import com.epam.atm.service.ITestDataReader;
import com.epam.atm.service.TestDataReader;
import com.epam.atm.service.TestDataReaderCreator;

public class UserWithCredentialsCreator extends UserFactory{
    private static final String TESTDATA_USER_NAME = "testdata.user.name";
    private static final String TESTDATA_USER_PASSWORD = "testdata.user.password";



    @Override
    public String getEmail() {

        return testdataReader.getTestData(TESTDATA_USER_NAME);

    }

    @Override
    public String getPassword() {
        return testdataReader.getTestData(TESTDATA_USER_PASSWORD);
    }
}
