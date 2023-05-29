package com.epam.atm.model.user;

import com.epam.atm.service.ITestDataReader;
import com.epam.atm.service.TestDataReader;
import com.epam.atm.service.TestDataReaderCreator;

public abstract class UserFactory {

    public abstract String getEmail();
    public abstract String getPassword ();
    ITestDataReader testdataReader = TestDataReaderCreator.getITestDataReader();
    public User createUser () {
        return new User (getEmail(),getPassword());
    };



}
