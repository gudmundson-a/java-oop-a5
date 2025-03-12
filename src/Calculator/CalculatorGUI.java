package Calculator;

import javax.swing.*;
import java.awt.*;
import java.util.function.IntBinaryOperator;

/*
Huvudklassen för miniräknarens GUI, här skapar vi och
hanterar all GUI-komponenter samt applikationens logik.
 */
public class CalculatorGUI extends JFrame {
    private final Situation situation;
    private final JPanel canvas;
    private final JPanel keypad;
    private final JLabel display;

    /*
    Kontrsuktorn för CalculatorGUI, den initialiserar
    och bygger upp miniräknaresn GUI.
     */
    public CalculatorGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Miniräknare");

        /*
        Skapar en ny JPanel vid namn canvas, tar även en
        GridBagLayout som parameter. Skapar GridBagConstraints
        och lägger till lite marginaler runt komponenterna.
        */
        canvas = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 3, 3, 3);

        /*
        Skapar en display som till att börja med visar "0", allignar
        texten till höger, gör kanterna svarta med 2pixels tjocklek.
        Skapar en ny font som är bold, gör bakgrunden vit, och ser
        även till att displayen är Opaque, behövs för att visa dess
        bakgrundsfärg.
         */
        display = new JLabel("0");
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        display.setFont(new Font("Arial", Font.BOLD, 30));
        display.setBackground(Color.WHITE);
        display.setOpaque(true);

        /*
        Sätter horisontala & vertikala positionen för displayen,
        ser även till att bredden sträcker sig över alla 4 kolumner.
        Lägger till canvas panelen med specificerade gbc's.
         */
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4; // Span across 4 columns
        gbc.fill = GridBagConstraints.HORIZONTAL;
        canvas.add(display, gbc);

        /*
        Skaparw en ny instans av Situation-klassen och tilldelar
        den till situation. Denna instans används för att hantera
        miniräknarens tillstånd. Display-objektet skickas till
        Situation-konstruktorn så att Situation kan uppdatera
        displayen.
         */
        situation = new Situation(display);

        /*
        Skapar en ny JPanel som har hand om miniräknarens keypad.
        Vi ser till att layouten blir 4x4.
         */
        keypad = new JPanel(new GridLayout(4, 4));

        /*
        En array av strängar (labels), dessa kommer definiera
        knapparna och dess funktioner.
         */
        String buttonLabels [] = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "=", "C", "+"
        };

        /*
        Har har vi en for each-loop som går igenom arrayen ovan,
        för varje sträng(label) kommer den skapa en knapp. Alltså
        om knappen är en operator (+, -, *, /) så kommer en BinOpButton
        skapas, ifall strängen är "=" så skapas en EqualsButton, är strängen
        "C" skapas en CancelButton och slutligen ifall det bara är en siffra
        så kommer "default" göra en DigitButton som tar strängens "siffra"
        och skapar en knapp med det som label.
         */
        for (String label : buttonLabels) {
            CalculatorButton button;
            switch (label) {
                case "+":
                    button = new BinOpButton(label, situation, (a, b) -> a + b);
                    break;
                case "-":
                    button = new BinOpButton(label, situation, (a, b) -> a - b);
                    break;
                case "*":
                    button = new BinOpButton(label, situation, (a, b) -> a * b);
                    break;
                case "/":
                    button = new BinOpButton(label, situation, (a, b) -> a / b);
                    break;
                case "=":
                    button = new EqualsButton(label, situation);
                    break;
                case "C":
                    button = new CancelButton(label, situation);
                    break;
                default:
                    button = new DigitButton(label, situation);
                    break;
            }
            keypad.add(button);
        }

        /*
        Sätter den horisontella & vertikala positionen för keypad-panelen.
        Ser till så att knapparna hamnar under displayen. Ser till så att
        knapparna tar upp hela bredden av miniräknaren.
         */
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        canvas.add(keypad, gbc);

        /*
        Lägger till canvas till JFrame, storleksanpassar så att alla
        komponenter får plats. Centrerar fönstret och gör det synligt.
         */
        add(canvas);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorGUI::new);
    }
}