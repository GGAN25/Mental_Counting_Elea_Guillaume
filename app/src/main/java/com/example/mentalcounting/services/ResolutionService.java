package com.example.mentalcounting.services;

import com.example.mentalcounting.models.OperationModel;
import com.example.mentalcounting.models.exceptions.OperatorException;

public class ResolutionService {

    public boolean Verif(OperationModel operation, int user_input) throws OperatorException {
        int result= ResultatOperation(operation);
        return user_input==result;
    }

    public int ResultatOperation(OperationModel operation) throws OperatorException{
        int nb1 = operation.getNumber1();
        int nb2 = operation.getNumber2();
        int result = 0;
        String operator = operation.getOperator();
        switch (operator){
            case "+":
                result=nb1+nb2;
                break;
            case "-":
                result=nb1-nb2;
                break;
            case "*":
                result=nb1*nb2;
                break;
            case "/":
                result=nb1/nb2;
                break;
            default:
                throw new OperatorException("@string/invalid_operator");
        }
        return result;
    }




}
