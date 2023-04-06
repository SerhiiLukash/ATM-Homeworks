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

public class ArithmeticDoubleTests {
 static   Calculator calculator;
    @BeforeAll
    public  void preTest () {
         calculator= new Calculator();
    }


    @Test
    @DisplayName("Divide two doubles")
    public void testDivideTwoDoubles() {

        assertEquals( 0.33, calculator.div(1.0,3.0), 0.1)  ;

    }
    @Test
    @DisplayName("Divide double on zero")
    public void testDivideOnZero() {
        assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {

                calculator.div(10.0, 0);
            }
        });

    }
    @Test
    @DisplayName("Multiply two doubles")
    public void testMultiplyTwoDoubles() {

        assertEquals( 2.25, calculator.mult(1.5,1.5))  ;

    }
    @Test
    @DisplayName("Subtraction for two doubles")
    public void testSubTwoDoubles() {

        assertEquals( 0.75, calculator.sub(2.25,1.5))  ;

    }
    @Test
    @DisplayName("Summation for two doubles")
    public void testSumTwoDoubles() {

        assertEquals( 3.75, calculator.sum(2.25,1.5))  ;

    }

}
