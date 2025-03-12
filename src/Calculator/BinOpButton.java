package Calculator;

import java.util.function.IntBinaryOperator;

public class BinOpButton extends CalculatorButton {
    private IntBinaryOperator operator;

    private void BinOpbutton(String keyName, Situation situation){
        super(keyName, situation);

    }

    private int applyAsInt(String leftOperand, String d){
        int leftOp = Integer.parseInt(leftOperand);
        int secondNum = Integer.parseInt(d);

        switch (d){

        }
    }

    void function(){

    }
}