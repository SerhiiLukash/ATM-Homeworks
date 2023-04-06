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

public class TrigonometryTests {
 static   Calculator calculator;
    @BeforeAll
    public  void preTest () {
         calculator= new Calculator();
    }

    // "Test cos" is in class CalculatorParameterizedTests


    @Test
    @DisplayName("Sin test")
    public void testSin() {

        assertEquals( 0, calculator.sin(3.14), 0.01)  ;

    }
    @Test
    @DisplayName("Tg test")
    public void testTg() {

        assertEquals( Math.sqrt(3), calculator.tg(Math.PI/3), 0.01)  ;

    }
    @Test
    @DisplayName("Ctg test")
    public void testCtg() {

        assertEquals( 0, calculator.ctg(Math.PI/2), 0.01);

    }

}
