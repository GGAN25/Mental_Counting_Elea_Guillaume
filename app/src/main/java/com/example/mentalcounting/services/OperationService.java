package com.example.mentalcounting.services;

import java.util.Random;
import com.example.mentalcounting.models.OperationModel;

public class OperationService {

    public OperationModel operation(){
        String operators = genOperator();
        if(operators=="/"){
            int div= genDiv();
            return new OperationModel(genDiv()*div,div,genOperator());
        }else{
            return new OperationModel(genNb(),genNb(),genOperator());
        }


    }

    public int genDiv(){
        int max = 99;
        Random random = new Random();
        return random.nextInt(max)+1;
    }

    public int genNb(){
        int max = 999;
        Random random = new Random();
        return random.nextInt(max)+1;
    }

    public String genOperator(){
        String[] operators = {"+","-","*","/"};
        int random = new Random().nextInt(operators.length);
        return operators[random];
    }

}
