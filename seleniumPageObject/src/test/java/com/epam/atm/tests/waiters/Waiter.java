package com.epam.atm.tests.waiters;

public class Waiter {


    public static void waitExplicit() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
