package com.epam.atm.test;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(CalculatorParameterResolver.class)
public class CalculatorParameterizedTests {

    @ParameterizedTest
    @CsvFileSource(resources = "/divisionData.csv")
    @DisplayName("Divide two doubles")
    public void testDivideTwoDoubles(double expected, double divident, double divider, Calculator calculator) {

        assertEquals(expected, calculator.div(divident, divider));

    }

    @ParameterizedTest
    @CsvSource({"1,0", "-1, 3.14"})
    @DisplayName("Test cos")
    public void testCos(double expected, double arg, Calculator calculator) {

        assertEquals(expected, calculator.cos(arg), 0.01);

    }

    @ParameterizedTest
    @ValueSource(longs = {1000000000, 2000000000})
    @DisplayName("Check if long is positive")
    public void testIsPositive(long value, Calculator calculator) {

        assertTrue(calculator.isPositive(value));

    }
}
