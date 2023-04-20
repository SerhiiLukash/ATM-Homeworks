package com.epam.atm.test;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(CalculatorParameterResolver.class)

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    static   Calculator calculator;
    @BeforeAll
    public  void preTest () {
        calculator= new Calculator();
    }
}
