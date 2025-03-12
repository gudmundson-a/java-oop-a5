package Calculator;

import Calculator.Situation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * Abstrakt basklass för alla knappar på miniräknaren.
 * Den definierar gemensamma egenskaper och metoder för alla knappar.
 */
public abstract class CalculatorButton extends JButton {
    protected Situation situation;
    /*
     Konstruktor för CalculatorButton.
     */
    public CalculatorButton(String text, Situation situation) {
        super(text);
        this.situation = situation;

        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(60, 60));
        setFont(new Font("Arial", Font.BOLD, 20));

        /*
        Skapar en ActionListener som vid knapptryck anropar den specifika knappens transition()-metod.
         */
        addActionListener(e -> transition());
    }

    // Abstrakt metod som underklasserna måste implementera
    protected abstract void transition();

    // Ändrar knappens färg
    public void setColor(Color color) {
        setBackground(color);
    }

    // Returnerar knappens text
    @Override
    public String toString() {
        return getText();
    }
}