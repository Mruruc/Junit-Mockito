package com.mruruc.understanding_Unit_Test;

public class Main {
    public static void main(String[] args) {

        Calculator calculator=new Calculator();

        int expected=3;

        int actual=calculator.sum(5,4);

        if (actual == expected){
            System.out.println("Test Passed!");
        }
        else {
            System.out.println("Test Failed!");
            System.out.println(
                    "Expected:" + expected +"\n"+
                    "Actual:" + actual
            );
        }


    }
}
