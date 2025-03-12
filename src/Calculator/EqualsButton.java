package Calculator;

import java.awt.*;

class EqualsButton extends CalculatorButton {
    public EqualsButton(String text, Situation situation) {
        super(text, situation);
    }

    /*
    Kollar ifall State == Input2, ifall det stämmer gör vi en beräkning av
    leftOperand och rightOperand. Detta görs med hjälp av applyAsInt och
    de två operatorerna "left & right" ges som parametrar.

    leftOperand är alltså det vi sparat tidigare och rightOperand är det
    som står i displayen just nu, det tas alltså från displayen och omvandlas
    till en integer.

    Vi ändrar färgerna tillbaka till samma som början och sätter State till
    HasResult.
     */
    @Override
    protected void transition() {
        if (situation.state == State.Input2) {
            int rightOperand = Integer.parseInt(situation.display.getText());
            int result = situation.binaryOperator.getOperator().applyAsInt(situation.leftOperand, rightOperand);
            situation.display.setText(String.valueOf(result));
            situation.binaryOperator.setColor(Color.LIGHT_GRAY);
            situation.state = State.HasResult;
        }
    }
}