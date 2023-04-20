package com.epam.atm.test;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.*;



public class ArithmeticLongInParallelTests extends BaseTest{




    @Test
    @DisplayName("Divide two integers")
    public void testDivideTwoLongs() {

        assertEquals( 0, calculator.div(1,3), 0.1)  ;

    }
    @Test
    @DisplayName("Divide integer on zero")
    public void testDivideOnZero() {
        assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {

                calculator.div(10, 0);
            }
        });

    }
    @Test
    @DisplayName("Multiply two integers")
    public void testMultiplyTwoLongs() {

        assertEquals( 150, calculator.mult(10,15))  ;

    }
    @Test
    @DisplayName("Subtraction for two integers")
    public void testSubTwoLongs() {

        assertEquals( 5, calculator.sub(7,2))  ;

    }
    @Test
    @DisplayName("Summation for two doubles")
    public void testSumTwoLongs() {

        assertEquals( -15, calculator.sum(-22,7))  ;

    }

}
