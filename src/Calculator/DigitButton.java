package Calculator;

import java.awt.*;
import java.util.function.IntBinaryOperator;

class DigitButton extends CalculatorButton {
    private final int digit;

    public DigitButton(String text, Situation situation) {
        super(text, situation);
        this.digit = Integer.parseInt(text); // Konvertera text till siffra
    }

    /*
     Hanterar logiken för vad som händer när en sifferknapp trycks.
     Beroende på miniräknarens tillstånd läggs siffran till i displayen,
     displayen återställs eller tillståndet ändras.
     */
    @Override
    protected void transition() {
        switch (situation.state) {
            case Input1:
            case Input2:
                String currentText = situation.display.getText();
                if (currentText.equals("0")) {
                    situation.display.setText(String.valueOf(digit));
                } else {
                    situation.display.setText(currentText + digit);
                }
                break;
            case OpReady:
                situation.display.setText(String.valueOf(digit));
                situation.state = State.Input2;
                break;
            case HasResult:
                situation.display.setText(String.valueOf(digit));
                situation.state = State.Input1;
                break;
        }
    }
}
