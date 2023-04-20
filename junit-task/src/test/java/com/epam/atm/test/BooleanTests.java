package com.epam.atm.test;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(CalculatorParameterResolver.class)

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class BooleanTests {
 static   Calculator calculator;
    @BeforeAll
    public  void preTest () {
         calculator= new Calculator();
    }

    // "Check if long is positive" is in class CalculatorParameterizedTests

    @DisplayName("Check if long is negative")
    @Test
    public void testIsNegative() {

        assertTrue(calculator.isNegative(-1000));

    }
    @DisplayName("Check if long is negative for positive value")
    @Test
    public void testIsNegativeForPositive() {

        assertFalse(calculator.isNegative(1000));

    }
}
