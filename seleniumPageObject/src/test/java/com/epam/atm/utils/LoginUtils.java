package com.epam.atm.utils;

import com.epam.atm.pageobjects.actions.ComposePage;

public class LoginUtils {
    public static Boolean isUserLogin(ComposePage composePage) {
        return composePage.ifElementIsDisplayed(composePage.getComposeBy());
    }
}
