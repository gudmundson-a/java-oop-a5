package Calculator;

import java.awt.*;

class CancelButton extends CalculatorButton {
    public CancelButton(String text, Situation situation) {
        super(text, situation);
    }

    /*
    Ifall användaren klickat på "C" så sätter vi återställer vi
    displayen genom att göra set.Text("0"). Vi ändrar tillbaka
    State till det initiala och vi kollar ifall det finns någon
    vald binaryOperator, isåfall återställer vi färgen till utgångsläget.
     */
    @Override
    protected void transition() {
        situation.display.setText("0");
        situation.state = State.Input1;
        if (situation.binaryOperator != null) {
            situation.binaryOperator.setColor(Color.LIGHT_GRAY);
        }
    }
}