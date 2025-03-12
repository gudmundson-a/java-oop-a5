package Calculator;


import java.awt.*;
import java.util.function.IntBinaryOperator;

class BinOpButton extends CalculatorButton {
    private final IntBinaryOperator operator; // Lagrar den operator som knappen representerar

    /*
    Konstruktor för BinOpButton.
    */
    public BinOpButton(String text, Situation situation, IntBinaryOperator operator) {
        super(text, situation);
        this.operator = operator;
    }

    /*
    Här ser vi till att ändra state när användaren väljer att använda en operator.

    Är case Input1 eller HasResult så tar vi värdet som står på displayen och
    konverterar det till en int som vi tilldelar situation.leftOperand.
    Vi sparar en referens till denna BinOPButton i situation.binaryOperator.
    Sedan ändrar vi state till OpReady (redo att ta emot nästa operand)
    och ändrar färgen på "denna" knapp till ORANGE.

    Är case OpReady så byter vi färgen på "tidigare" markerade operatorknappen
    tillbaka till grå. Vi sparar en referens till "denna" BinOpButton i situation.binaryOperator.
    Vi ser till att nu färga "denna" knapp ORANGE istället så användaren vet
    att den är vald nu.

    Är caset Input2 så tar vi och gör om värdet i displayen till en Integer och ger
    detta värdet till situation.leftOperand. Vi sparar en referens till "denna" BinOpButton
    i situation.binaryOperator. Sedan ändrar vi state till OpReady och ändrar
    färgen på "denna" knappen till ORANGE.
     */
    @Override
    protected void transition() {
        switch (situation.state) {
            case Input1:
            case HasResult:
                situation.leftOperand = Integer.parseInt(situation.display.getText());
                situation.binaryOperator = this;
                situation.state = State.OpReady;
                setColor(Color.ORANGE);
                break;
            case OpReady:
                situation.binaryOperator.setColor(Color.LIGHT_GRAY);
                situation.binaryOperator = this;
                setColor(Color.ORANGE);
                break;
            case Input2:
                situation.leftOperand = Integer.parseInt(situation.display.getText());
                situation.binaryOperator = this;
                situation.state = State.OpReady;
                setColor(Color.ORANGE);
                break;
        }
    }

    public IntBinaryOperator getOperator() {
        return operator;
    }
}