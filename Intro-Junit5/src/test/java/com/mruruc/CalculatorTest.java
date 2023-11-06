package com.mruruc;

import com.mruruc.understanding_Unit_Test.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
// This is the default ;
public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void init(){
        calculator=new Calculator();
    }
    @Test
    public void test_instance(){
        assertInstanceOf(Calculator.class,calculator);
    }


    @Test
    public void test_sum(){
        int actual=calculator.sum(5,9);
        int expected=14;

        assertEquals(expected,actual,"Successful!");
    }

    // Test driven development;

    @Test
    void area_of_circle_test(){
        double actual=calculator.computeArea(2);
        double expected=12.566370614359172;
        assertEquals(expected,actual,"Calculate the Area of Circle!");
    }


    // Testing a exception;

    @Test
    @DisplayName("Testing Division By Zero.")
    void test_division(){
        assertThrows(ArithmeticException.class,
                     ()->calculator.division(5,0),
                 "Division By Zero causes Exceptions.");
    }

    // Testing Boolean Value:

    @Test
    @DisplayName("Testing isNumberEqual Method")
    void test_isNumberEqual(){
        boolean actual=calculator.isEqualNumber(5,5);
        assertTrue(actual,"Number Should be Equal!");
    }

    // assertAll
    @Test
    @DisplayName("Multiply Method")
    void test_multiplication(){
        assertAll(
                ()-> assertEquals(0,calculator.multiple(8,0)),
                ()-> assertEquals(50,calculator.multiple(5,10)),
                ()-> assertEquals(-4, calculator.multiple(-2,2))
        );
    }



    // Nested tests(Grouping the Tests):

    @Nested
    class Sum{

        @Test
        @DisplayName("Testing Two Positive Number:")
        void sum_v1_test(){
            assertEquals(5,calculator.sum(3,2),"Adding Two Positive NUmber");
        }

        @Test
        @DisplayName("Testing Two Negative Number:")
        void sum_v2_test(){
            assertEquals(-5,
                         calculator.sum(-3,-2),
                    "Adding Two Negative Number Result will be Negative.");
        }
    }

    @AfterEach
    @DisplayName("After Each method Execution the calculator instance will be discarded.")
    void cleanUp(){
        // its enough to create method and annotated with AfterEach,
        // it will be called and calculator instance will be out of scope,
        //and finally will be garbage collected.

        ///or we can explicitly assign calculator to null value:
        calculator=null;
        System.out.println("After each method execution");
    }

}
