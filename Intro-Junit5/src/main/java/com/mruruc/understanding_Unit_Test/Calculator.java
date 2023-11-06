package com.mruruc.understanding_Unit_Test;

public class Calculator {

    public int sum(int x, int y){
        return x + y ;
    }

    public double computeArea(int r){
        return Math.PI * Math.pow(r,2);
    }

    public double division(double x,double y){
        if (y == 0){
            throw new ArithmeticException("Denominator Can Not be Zero!");
        }
        return Math.floor(x / y);
    }

    public boolean isEqualNumber(int x,int y){
        return x == y;
    }

    public int multiple(int x,int y){
        return x * y;
    }
}
