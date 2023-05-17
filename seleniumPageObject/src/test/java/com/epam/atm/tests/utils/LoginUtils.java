package com.epam.atm.tests.utils;

import com.epam.atm.tests.pageobjects.actions.ComposePage;

public class LoginUtils {
    public static Boolean isUserLogin(ComposePage composePage) {
        return composePage.ifElementIsDisplayed(composePage.getComposeBy());
    }
}
