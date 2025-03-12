package Calculator;

import javax.swing.*;

/*
Klassen för Situation, här lagrar vi det aktuella
tillståndet för miniräknaren (Initialt Input1). Vi ger
en referens till BinOPButton som representerar den valda
operatorn. Vi har även en referens till
 */
class Situation {
    State state = State.Input1;
    JLabel display;
    BinOpButton binaryOperator;
    int leftOperand;


    Situation(JLabel display){
        this.leftOperand = 0;
        this.display = display;
    }
}