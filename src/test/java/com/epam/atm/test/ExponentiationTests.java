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

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(CalculatorParameterResolver.class)

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class ExponentiationTests {
 static   Calculator calculator;
    @BeforeAll
    public  void preTest () {
         calculator= new Calculator();
    }


    @Test
    @DisplayName("Exponentiation test")
    public void testPow() {

        assertEquals( 6.25, calculator.pow(2.5,2.0))  ;

    }
    @Test
    @DisplayName("Exponentiation test for Negative value")
    public void testPowNegative() {

        assertEquals( -15.625, calculator.pow(-2.5,3.0))  ;

    }

    @Test
    @DisplayName("Square root test")
    public void testSquareRoot() {

        assertEquals( 2.5, calculator.sqrt(6.25))  ;

    }
    @Test
    @DisplayName("Square root for Negative value")
    public void testSquareRootNegative() {

        assertEquals( NaN, calculator.sqrt(-6.25))  ;

    }

}
