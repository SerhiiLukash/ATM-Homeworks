package com.epam.atm.model.user;

import com.epam.atm.service.TestDataReader;

public  class UserWithoutCredentialsCreator extends UserFactory{
    private static final String TESTDATA_USER_NAME = "testdata.user.name";



    @Override
    public String getEmail() {
        return testdataReader.getTestData(TESTDATA_USER_NAME);
    }

    @Override
    public String getPassword() {
        return "InvalidPassword";
    }

}
