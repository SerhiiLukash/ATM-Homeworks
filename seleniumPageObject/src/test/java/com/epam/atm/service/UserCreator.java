package com.epam.atm.service;

import com.epam.atm.model.User;

public class UserCreator {
    private static final String TESTDATA_USER_NAME = "testdata.user.name";
    private static final String TESTDATA_USER_PASSWORD = "testdata.user.password";

    public static User withCredentials() { return new User (TestDataReader.getTestData(TESTDATA_USER_NAME), TestDataReader.getTestData(TESTDATA_USER_PASSWORD)) ;    }
    public static User withoutFile () {  return new User ("serhii1testmail@gmail.com", "Password1#") ;}

}
