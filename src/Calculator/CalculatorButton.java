package Calculator;

import javax.swing.*;
import java.awt.*;

abstract class CalculatorButton extends JButton {
    protected Situation situation;

    private CalculatorButton(String keyName, Situation situation){
        super(keyName);
        this.situation = situation;

        setBackground(Color.lightGray);
        setOpaque(true);
        setBorderPainted(false);
        setPreferredSize(new Dimension(60, 60));
        setFont(new Font("Arial", Font.BOLD, 18));

        addActionListener(e -> transition());
    }

    void transition(){

    }

    void setColor(){

    }

    public String toString(){

        return "";
    }
}