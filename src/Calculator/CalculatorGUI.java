package Calculator;

import javax.swing.*;
import java.awt.*;

class CalculatorGUI extends JFrame {
    private CalculatorGUI(){
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel canvas = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel display = new JLabel("0", SwingConstants.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setPreferredSize((Dimension) BorderFactory.createLineBorder(Color.BLACK, 2));
        display.setOpaque(false);
        display.setBackground(Color.WHITE);

        Situation situation = new Situation(display);

        JPanel keyPad = new JPanel(new GridLayout(4,4));
        keyPad.setPreferredSize(new Dimension(240,240));

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "=", "C", "+"
        };


    }
}