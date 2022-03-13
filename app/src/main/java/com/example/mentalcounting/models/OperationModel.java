package com.example.mentalcounting.models;



public class OperationModel {

    private final int number1,number2;
    private final String operator;

    public OperationModel(int number1, int number2, String operator) {
        this.number1 = number1;
        this.number2 = number2;
        this.operator = operator;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public String getOperator() {
        return operator;
    }
}
